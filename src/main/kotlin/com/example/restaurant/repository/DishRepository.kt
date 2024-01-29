package com.example.restaurant.repository

import com.example.restaurant.entity.Dish
import org.springframework.data.repository.CrudRepository

interface DishRepository: CrudRepository<Dish, Long> {
}