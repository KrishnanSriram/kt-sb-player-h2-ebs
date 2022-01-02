package com.example.kotlindb.service

import com.example.kotlindb.model.Player
import com.example.kotlindb.model.PlayerInputDTO
import com.example.kotlindb.repository.PlayerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PlayerService(val playerRepository: PlayerRepository) {
    fun listAllPllayers() : Iterable<Player> {
        return playerRepository.findAll()
    }

    fun findPlayerById(id: String): Optional<Player> {
        return playerRepository.findById(id)
    }

    fun addPlayer(player: PlayerInputDTO): Player? {
        var newPlayer: Player = Player( name=player.name, country = player.country, age=player.age)
        return playerRepository.save(newPlayer)
    }
}