package com.igorsousa.exercicio_tui.controllers

import com.igorsousa.exercicio_tui.exceptions.QuoteNotFoundException
import com.igorsousa.exercicio_tui.models.Quote
import com.igorsousa.exercicio_tui.repositories.QuotesRepository
import com.igorsousa.exercicio_tui.services.QuotesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/quotes")
class QuotesController(
    @Autowired val quotesService: QuotesService
) {
    @GetMapping("/{id}")
    fun getQuote(@PathVariable("id") id: String): Mono<Quote> {
        return quotesService.findQuoteById(id)
            .switchIfEmpty(Mono.error(QuoteNotFoundException("Quote not found")))

    }

    @GetMapping("")
    fun getQuoteByAuthor(@RequestParam("author") author: String): Flux<Quote> {
        return quotesService.findQuoteByAuthor(author)
    }
}