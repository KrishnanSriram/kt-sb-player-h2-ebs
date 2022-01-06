package com.example.kotlindb.controller

import com.example.kotlindb.model.Player
import com.example.kotlindb.model.PlayerInputDTO
import com.example.kotlindb.service.PlayerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController()
@RequestMapping("/players")
class PlayerController(val playerService: PlayerService) {
    @GetMapping()
    fun listAllPlayers(): ResponseEntity<Iterable<Player>> {
        return ResponseEntity(playerService.listAllPllayers(), HttpStatus.OK)
    }

    @PostMapping()
    fun addPlayer(@RequestBody player: PlayerInputDTO): ResponseEntity<Player> {
        val retPlayer: Player? = playerService.addPlayer(player)
        if(retPlayer != null) {
            return ResponseEntity(retPlayer!!, HttpStatus.OK)
        }
        throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Failed to add player. Please check your JSON and try again")
    }
}