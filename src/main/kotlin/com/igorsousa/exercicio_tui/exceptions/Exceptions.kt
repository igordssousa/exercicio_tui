package com.igorsousa.exercicio_tui.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class QuoteNotFoundException(message: String): RuntimeException (message) {}