package com.reto03.grupog6.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VistaController  {
    @GetMapping ("/index")
    public String index() {
        return "index";
    }
}
