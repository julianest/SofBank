package com.jhsoft.SofBank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String hello() {
        return "¡Aplicación levantada correctamente!";
    }
    //http://localhost:8080/ "Debe verse cuando se levante la aplicacion esto es solo
    // para generar una inforamcion al levantarse ya que sino generar un while error pero
    // es normal ya que no se tiene controladores ni nada".
}
