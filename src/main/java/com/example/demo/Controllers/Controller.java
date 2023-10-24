package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.IService;

@RestController
public class Controller  implements IController{


    private final IService service;
    public Controller(final IService service){

        this.service = service;
        this.service.get();
    }
    @Override
    public String Hello(){
        return this.service.get();
    }
}
