package com.rodrigo.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Value("${app.message}") // vem dos arquivos de dev e prod
    private String appMessage;

    @GetMapping("/")
    public String getAppMessage() {
        return this.appMessage;
    }
}
