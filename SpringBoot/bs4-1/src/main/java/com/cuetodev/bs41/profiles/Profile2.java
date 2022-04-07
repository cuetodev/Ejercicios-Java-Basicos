package com.cuetodev.bs41.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("perfil2")
public class Profile2 implements ProfileService {
    @Value("${perfil}")
    private String perfil;

    @Override
    public String miFuncion() {
        return this.perfil;
    }
}
