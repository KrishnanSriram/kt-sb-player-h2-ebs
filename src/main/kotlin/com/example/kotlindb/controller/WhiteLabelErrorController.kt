package com.example.kotlindb.controller

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest

@Controller
class WhiteLabelErrorController: ErrorController {
    @GetMapping("/error")
    fun handleError(request: HttpServletRequest): String {
        return "error"
        //return "You have reached KTSBPlayer service. the path you are looking for cannot be found. Please check your URL or try again later"
    }
}