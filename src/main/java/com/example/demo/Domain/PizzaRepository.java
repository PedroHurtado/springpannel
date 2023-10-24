package com.example.demo.Domain;


//JPA
public interface PizzaRepository {
    
    public void add(Pizza pizza);
    public void update(Pizza pizza);
    public void remove(Pizza pizza);
    public Pizza get(Pizza.PizzaId Id);
}
