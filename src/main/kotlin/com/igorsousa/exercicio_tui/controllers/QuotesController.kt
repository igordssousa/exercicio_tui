package com.igorsousa.exercicio_tui.controllers

import com.igorsousa.exercicio_tui.exceptions.QuoteNotFoundException
import com.igorsousa.exercicio_tui.models.Quote
import com.igorsousa.exercicio_tui.services.QuotesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/quotes")
class QuotesController(
    @Autowired val quotesService: QuotesService
) {
    @GetMapping("/{id}")
    @ResponseBody
    fun getQuote(@PathVariable("id") id: String): Mono<Quote> {
        return quotesService.findQuoteById(id)
            .switchIfEmpty(Mono.error(QuoteNotFoundException("Quote not found")))
    }

    @GetMapping("")
    @ResponseBody
    fun getQuoteByAuthor(
        @RequestParam(name = "author", required = false) author: String?,
        page: Pageable
    ): Flux<Quote> {
        return quotesService.findQuoteByAuthor(author, page)
    }
}