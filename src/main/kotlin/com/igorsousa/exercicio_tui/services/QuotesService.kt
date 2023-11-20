package com.igorsousa.exercicio_tui.services

import com.igorsousa.exercicio_tui.models.Quote
import com.igorsousa.exercicio_tui.repositories.QuotesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class QuotesService(
    @Autowired private val quotesRepository: QuotesRepository
) {
    fun findQuoteById(id: String): Mono<Quote> {
        return quotesRepository.findById(id)
    }

    fun findQuoteByAuthor(author: String?, page: Pageable): Flux<Quote> {
        if(author.isNullOrEmpty()) {
            return quotesRepository.findAllBy(page)
        }
        return quotesRepository.findByQuoteAuthorLikeIgnoreCase(author, page)
    }
}