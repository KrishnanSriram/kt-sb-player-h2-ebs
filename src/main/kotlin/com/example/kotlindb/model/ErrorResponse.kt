package com.example.kotlindb.model

import org.springframework.http.HttpStatus
import java.util.*

class ErrorResponse(status: HttpStatus, val message: String, val stackTrace: String? = null) {
    val code: Int
    val strstatus: String
    val timeStamp: Date = Date()

    init {
        code = status.value()
        strstatus = status.name
    }
}
