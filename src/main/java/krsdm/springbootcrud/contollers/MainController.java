package krsdm.springbootcrud.contollers;

import krsdm.springbootcrud.models.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String formlogin() {
        return "login";
    }

    @GetMapping("/user")
    public String userProfile(@AuthenticationPrincipal User activeUser, Model model) {
        model.addAttribute("user", activeUser);
        return "user";
    }
}
