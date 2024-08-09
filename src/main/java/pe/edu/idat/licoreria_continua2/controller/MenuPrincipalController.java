package pe.edu.idat.licoreria_continua2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuPrincipalController {

    @GetMapping("/menuprincipal")
    public String menuPrincipal() {
        return "menuprincipal";
    }
}