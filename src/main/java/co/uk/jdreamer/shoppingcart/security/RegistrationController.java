package co.uk.jdreamer.shoppingcart.security;

import co.uk.jdreamer.shoppingcart.loginModels.LoginUser;
import co.uk.jdreamer.shoppingcart.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String register(LoginUser user) {
        return "checkout";
    }

    @PostMapping
    public String register(@Valid LoginUser user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "checkout";
        }

        return "redirect:/login";
    }
}
