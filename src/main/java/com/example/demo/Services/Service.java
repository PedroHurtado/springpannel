package com.example.demo.Services;

import org.springframework.stereotype.Component;

import com.example.demo.Repositories.IRepository;

@Component
public class Service implements IService {

    public final IRepository repository;
    public Service(final IRepository repository){
        this.repository = repository;
    }
    @Override
    public String get() {
        return this.repository.get();
    }
    
}
