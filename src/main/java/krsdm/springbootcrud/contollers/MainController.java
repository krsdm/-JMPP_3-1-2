package krsdm.springbootcrud.contollers;

import krsdm.springbootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String index (Principal principal, Model model) {
        model.addAttribute("userName", principal.getName());
        return "index";
    }

    @GetMapping("/login")
    public String formlogin() {
        return "login";
    }

    @GetMapping("/user")
    public String userProfile(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByName(principal.getName()));
        return "admin/user";
    }
}
