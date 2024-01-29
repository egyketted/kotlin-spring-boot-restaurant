package com.example.restaurant.service

import com.example.restaurant.dto.Menu
import com.example.restaurant.entity.Dish
import com.example.restaurant.repository.DishRepository
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class DishService(val repository: DishRepository, val kafkaTemplate: KafkaTemplate<String, String>) {

    val topic = "kitchen_topic"

    fun getMenu(): Menu = Menu(repository.findAll().toList())
    fun getDishDetails(id: Long): Dish = findByIdOrThrow(id)
    fun createDish(name: String, price: Int): Dish = repository.save(Dish(0, name, price))

    fun orderFood(id: Long): String {
        sendMessage("food_order", findByIdOrThrow(id).name)
        return "Please proceed to table " + Math.round(1 + Math.random() * 100)
    }

    fun updateDish(id: Long, name: String, price: Int): Dish {
        val oldDish = findByIdOrThrow(id)

        oldDish.name = name
        oldDish.price = price

        return repository.save(oldDish)
    }

    fun deleteDish(id: Long): Dish {
        val oldDish = findByIdOrThrow(id)

        repository.delete(oldDish)
        return oldDish
    }

    private fun findByIdOrThrow(id: Long): Dish = repository.findById(id).orElseThrow{IllegalArgumentException("Id not found")}

    private fun sendMessage(key: String, message: String) {
        println("Sending message")
        kafkaTemplate.send(topic, key, message)
    }

}