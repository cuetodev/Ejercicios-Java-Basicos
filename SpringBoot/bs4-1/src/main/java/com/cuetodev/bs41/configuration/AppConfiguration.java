package com.cuetodev.bs41.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@ConfigurationProperties
@Component
public class AppConfiguration {
    private String url;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "\n-- AppConfiguration --\n" +
                "Url: " + url + '\n' +
                "Password: " + password;
    }
}
