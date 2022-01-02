package com.example.kotlindb.repository

import com.example.kotlindb.model.Player
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.Repository

interface PlayerRepository: CrudRepository<Player, String> {
}