package com.example.kotlindb.model

import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Table

interface IPlayer {
    var name: String
    var country: String
    var age: Int
}
data class PlayerInputDTO(override var name: String, override var country: String, override var age: Int): IPlayer
@Entity
@Table(name = "Players")
data class Player(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String = "",
    val country: String = "",
    val age: Int = 0
)