package com.igorsousa.exercicio_tui.repositories

import com.igorsousa.exercicio_tui.models.Quote
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import reactor.core.publisher.Flux

@EnableReactiveMongoRepositories
interface QuotesRepository : ReactiveMongoRepository<Quote, String> {
    fun findByQuoteAuthorLikeIgnoreCase(quoteAuthor: String): Flux<Quote>
}