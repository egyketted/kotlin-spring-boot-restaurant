package com.example.restaurant.controller

import com.example.restaurant.dto.Menu
import com.example.restaurant.entity.Dish
import com.example.restaurant.service.DishService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class DishController(val service: DishService) {

    @QueryMapping
    fun getMenu(): Menu = service.getMenu()

    @QueryMapping
    fun getDishDetails(@Argument id: Long): Dish = service.getDishDetails(id)

    @QueryMapping
    fun orderFood(@Argument id: Long): String = service.orderFood(id)

    @MutationMapping
    fun createDish(@Argument name: String, @Argument price: Int): Dish = service.createDish(name, price)

    @MutationMapping
    fun updateDish(@Argument id: Long, @Argument name: String, @Argument price: Int): Dish = service.updateDish(id, name, price)

    @MutationMapping
    fun deleteDish(@Argument id: Long): Dish = service.deleteDish(id)
}