package com.igorsousa.exercicio_tui.controllers

import com.igorsousa.exercicio_tui.models.Quote
import com.igorsousa.exercicio_tui.repositories.QuotesRepository
import com.igorsousa.exercicio_tui.services.QuotesService
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import reactor.core.publisher.Mono

@WebMvcTest(QuotesController::class)
class QuotesControllerTest {
    @MockBean
    private lateinit var service: QuotesService
    @Autowired
    private lateinit var mvc: MockMvc

    private val quoteId = "5eb17aadb69dc744b4e70e45"
    private val singleQuote = Quote(
        id = "5eb17aadb69dc744b4e70e45",
        quoteAuthor = "Igor Sousa",
        quoteText = "ez mid",
        quoteGenre = "dota"
    )

    @Test
    fun getQuoteSuccess(){
        BDDMockito.given(service.findQuoteById(quoteId))
            .willReturn(Mono.just(singleQuote))

        mvc.perform(
            MockMvcRequestBuilders.get("/quotes/5eb17aadb69dc744b4e70e45")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().is2xxSuccessful)
    }

    @Test
    fun getQuoteNotFound(){
        BDDMockito.given(service.findQuoteById("nothing_here"))
            .willReturn(Mono.empty())

        mvc.perform(
            MockMvcRequestBuilders.get("/quotes/nothing_here")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound)
    }
}