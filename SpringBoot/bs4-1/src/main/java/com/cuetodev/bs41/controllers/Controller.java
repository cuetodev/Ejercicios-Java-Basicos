package com.cuetodev.bs41.controllers;

import com.cuetodev.bs41.configuration.AppConfiguration;
import com.cuetodev.bs41.configuration.MyConfiguration;
import com.cuetodev.bs41.profiles.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("persona")
public class Controller {
    @Autowired
    private AppConfiguration appConfiguration;

    @Autowired
    private MyConfiguration myConfiguration;

    @Autowired
    private ProfileService profileService;

    @PostConstruct
    public void printMyParametersBeforeRunning() {
        System.out.println(myConfiguration.toString());
    }

    @GetMapping("/parametros")
    public String getParameters() {
        return appConfiguration.toString();
    }

    @GetMapping("/miconfiguracion")
    public String getMyParameters() {
        return myConfiguration.toString();
    }

    @GetMapping("/perfil")
    public String getPerfil() {
        return profileService.miFuncion();
    }
}
