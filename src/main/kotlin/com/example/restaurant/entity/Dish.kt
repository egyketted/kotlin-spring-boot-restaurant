package com.example.restaurant.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity(name = "dishes")
data class Dish(@Id @GeneratedValue var id: Long, var name: String, var price: Int) {
    constructor(): this(0, "", 0)
}