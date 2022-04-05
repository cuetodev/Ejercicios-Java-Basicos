package com.springboot_startup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Controlador1 {

    @GetMapping("/{userName}")
    public String returnUserName(@PathVariable String userName) {
        return "Hola " + userName;
    }
}
