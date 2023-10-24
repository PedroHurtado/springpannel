package com.example.demo.Infraestructure.Pizza;

import org.springframework.stereotype.Component;

import com.example.demo.Domain.Pizza;
import com.example.demo.Domain.Pizza.PizzaId;
import com.example.demo.Domain.PizzaRepository;

@Component
public class PizzaRepositoryImpl implements PizzaRepository {

    @Override
    public void add(Pizza pizza) {
        
        
    }

    @Override
    public void update(Pizza pizza) {
        
    }

    @Override
    public void remove(Pizza pizza) {
        
    }

    @Override
    public Pizza get(PizzaId Id) {
        return null;
    }
    
}
