package com.example.demo.Domain;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.demo.Domain.Exceptions.NotIngredientExists;

import lombok.EqualsAndHashCode;
import lombok.Getter;

public class Pizza {
    //Value Object
    public static record PizzaId(UUID id) {

    }

    @EqualsAndHashCode.Include
    private PizzaId id;

    @Getter
    private String name;
    @Getter
    private String description;

    private final Set<Ingredient> ingredients;

    protected Pizza(PizzaId id, String name, String description, Set<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredient() {
        return this.ingredients.stream().collect(Collectors.toList());
    }

    public static Pizza create(PizzaId id, String name, String description, Set<Ingredient> ingredients) {
        return new Pizza(id, name, description, ingredients);
    }

    public void update(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        if(!ingredients.contains(ingredient)){
            throw new NotIngredientExists();
        }
        this.ingredients.remove(ingredient);
    }

    public double getPrice() {
        return this.ingredients.stream()
        .map(i->i.getPrice())
        .reduce(0.0, (subtotal, element) -> subtotal + element) * 1.2;
            
    }

}
