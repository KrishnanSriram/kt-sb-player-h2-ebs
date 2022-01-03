package com.example.kotlindb.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/")
@RestController
class HomeController {
    @GetMapping()
    public fun home() : ResponseEntity<String> {
        val response = "Check out /player, /actuator endpoint(s) for more information!!"
        return ResponseEntity(response, HttpStatus.OK)
    }
}