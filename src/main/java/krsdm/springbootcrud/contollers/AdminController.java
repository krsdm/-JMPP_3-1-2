package krsdm.springbootcrud.contollers;

import krsdm.springbootcrud.models.User;
import krsdm.springbootcrud.service.RoleService;
import krsdm.springbootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String userList(@AuthenticationPrincipal User activeUser, Model model) {
        model.addAttribute("roles", roleService.getRoles());
        model.addAttribute("user", activeUser);
        model.addAttribute("users", userService.getAllUsers());
        return "admin/admin";
    }

    @GetMapping("new")
    public String newUser(@AuthenticationPrincipal User activeUser, Model model) {
        model.addAttribute("user", activeUser);
        model.addAttribute("roles", roleService.getRoles());
        model.addAttribute("newuser", new User());
        return "admin/new";
    }

    @PostMapping("new")
    public String createUser(@AuthenticationPrincipal User activeUser,
                             @ModelAttribute("newuser") @Valid User newuser,
                             BindingResult bindingResult, Model model) {

        // Если юзер с таким именем уже существует, сообщим об этом
        if (userService.getUserByName(newuser.getName()) != null) {
            bindingResult.addError(new FieldError("newuser", "name",
                    String.format("User with first name \"%s\" is already exist!", newuser.getName())));
            model.addAttribute("roles", roleService.getRoles());
            model.addAttribute("user", activeUser);
            return "admin/new";
        }

        // Иначе достаем для юзера по указанным именам роли из базы и сохраняем
        newuser.setRoles(newuser.getRoles().stream()
                .map(role -> roleService.getByName(role.getName()))
                .collect(Collectors.toSet()));
        userService.saveUser(newuser);
        return "redirect:/admin";
    }

    @PatchMapping("{id}/edit")
    public String updateUser(@AuthenticationPrincipal User activeUser,
                             @ModelAttribute("user") User user, Model model) {

        // если имя было изменено и юзер с таким именем уже существует, сообщим об этом
        if (!user.getName().equals(userService.getUserById(user.getId()).getName()) &&
                userService.getUserByName(user.getName()) != null) {
            model.addAttribute("usernameError", String.format("User with first name \"%s\" is already exist!", user.getName()));
            model.addAttribute("roles", roleService.getRoles());
            model.addAttribute("users", userService.getAllUsers());
            model.addAttribute("user", activeUser);
            return "admin/admin";
        }

        // иначе достаем для юзера по указанным именам роли из базы и сохраняем
        user.setRoles(user.getRoles().stream()
                .map(role -> roleService.getByName(role.getName()))
                .collect(Collectors.toSet()));
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("{id}")
    public String deleteUser(@AuthenticationPrincipal User activeUser, @PathVariable("id") long id) {
        userService.removeUser(id);
        // если admin удалил сам себя, нужно его разлогинить
        if (id == activeUser.getId()) {
            return "redirect:/logout";
        }
        return "redirect:/admin";
    }

}
