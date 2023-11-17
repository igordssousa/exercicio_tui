package com.igorsousa.exercicio_tui.models

import org.springframework.data.mongodb.core.mapping.Document

@Document("quotes")
data class Quote(
    val id: String,
    val quoteText: String,
    val quoteAuthor: String,
    val quoteGenre: String
)