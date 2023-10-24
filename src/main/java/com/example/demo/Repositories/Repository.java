package com.example.demo.Repositories;

import org.springframework.stereotype.Component;

@Component
public class Repository  implements IRepository{

    public Repository(){
        
    }
    @Override
    public String get() {        
       return "Hello World";
    }
    
}
