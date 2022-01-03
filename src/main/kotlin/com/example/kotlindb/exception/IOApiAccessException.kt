package com.example.kotlindb.exception

import java.io.IOException

class IOApiAccessException: IOException{
    constructor(message: String): super(message) {

    }
}