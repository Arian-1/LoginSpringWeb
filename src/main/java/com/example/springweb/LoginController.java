package com.example.springweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {


    @GetMapping("/inicio")
    public String showLoginForm(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("errorMsg", "Inicio de sesión no fue exitoso. Inténtalo de nuevo.");
        }
        return "login";
    }


    @PostMapping("/inicio")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {

        if ("Ricardo".equals(username) && "62231".equals(password)) {
            model.addAttribute("username", username);
            return "home";
        } else {

            return "redirect:/inicio?error=true";
        }
    }
}
