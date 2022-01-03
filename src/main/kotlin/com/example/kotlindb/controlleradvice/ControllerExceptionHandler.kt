package com.example.kotlindb.controlleradvice

import com.example.kotlindb.model.ErrorResponse
import org.hibernate.exception.ConstraintViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException
import java.io.PrintWriter
import java.io.StringWriter
import java.util.*
import javax.persistence.EntityNotFoundException
import javax.persistence.NoResultException
import kotlin.NoSuchElementException

@ControllerAdvice
@RestController
class ControllerExceptionHandler {
    @ExceptionHandler(
        ConstraintViolationException::class,
        HttpClientErrorException.BadRequest::class,
        MethodArgumentNotValidException::class,
        MissingServletRequestParameterException::class,
        IllegalArgumentException::class
    )
    fun constraintVoilationException(e: Exception): ResponseEntity<ErrorResponse> {
        return generateErrorResponse(HttpStatus.BAD_REQUEST, "Bad Request", e)
    }

    @ExceptionHandler(
        EntityNotFoundException::class,
        NoSuchElementException::class,
        NoResultException::class,
        EmptyResultDataAccessException::class,
        IndexOutOfBoundsException::class,
        KotlinNullPointerException::class
    )
    fun notFoundException(e: Exception): ResponseEntity<ErrorResponse> {
        return generateErrorResponse(HttpStatus.NOT_FOUND, "Resource not found", e)
    }

    @ExceptionHandler(
        Exception::class
    )
    fun internalServerErrorException(e: Exception): ResponseEntity<ErrorResponse> {
        return generateErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Generic internal error", e)
    }

    private fun generateErrorResponse(status: HttpStatus, message: String, e: Exception): ResponseEntity<ErrorResponse> {
        val sw = StringWriter()
        val pw = PrintWriter(sw)
        e.printStackTrace(pw)
        val stackTrace = sw.toString()
        // cascade/abstract stack trace by ENV
        val stackTraceMessage = when(System.getenv("ENV").uppercase(Locale.getDefault())) {
            "STAGING" -> stackTrace
            "PRODUCTION" -> null
            else -> stackTrace
        }
        return ResponseEntity(ErrorResponse(status = status, message, stackTraceMessage), status)
    }
}