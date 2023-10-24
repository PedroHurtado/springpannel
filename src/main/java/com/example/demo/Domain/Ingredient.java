package com.example.demo.Domain;

import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;



@Getter
public class Ingredient {
    public static record IngredientId(UUID id){

    }    
    @EqualsAndHashCode.Include
    private IngredientId id;
    
    private String name;
    private Double price;

    protected Ingredient(IngredientId id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }    
    public static Ingredient create(IngredientId id, String name, Double price){
        return new Ingredient(id,name,price);
    }

    public void Update(String name,double price){
        this.name= name;
        this.price = price;
    }
}
