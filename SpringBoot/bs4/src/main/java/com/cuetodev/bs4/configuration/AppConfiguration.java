package com.cuetodev.bs4.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties()
public class AppConfiguration {
    private String var1;
    private int var2;
    @Value("${var3:var3 no tiene valor}")
    private String var3;

    public String getVar3() {
        return var3;
    }

    public void setVar3(String var3) {
        this.var3 = var3;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public int getVar2() {
        return var2;
    }

    public void setVar2(int var2) {
        this.var2 = var2;
    }

    @Override
    public String toString() {
        return "\n-- AppConfiguration --\n" +
                "Var1: " + var1 + '\n' +
                "Var2: " + var2;
    }
}
