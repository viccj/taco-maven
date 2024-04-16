package com.lazyvic.data;

import com.lazyvic.Ingredient;
import org.springframework.data.repository.CrudRepository;


public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
