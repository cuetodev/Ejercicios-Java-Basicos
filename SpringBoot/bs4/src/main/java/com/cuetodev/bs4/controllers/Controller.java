package com.cuetodev.bs4.controllers;

import com.cuetodev.bs4.configuration.AppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("properties")
public class Controller {

    @Autowired
    AppConfiguration appConfiguration;

    @GetMapping("/valores")
    public String readProperties() {
        return appConfiguration.toString();
    }

    @GetMapping("/var3")
    public String readVar3() {
        return "Valor de var3: " + appConfiguration.getVar3();
    }
}
