package com.tw

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class MovieControllerGetMovieTests() {

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun `get a movie`() {

        val rsp: String = client.toBlocking().retrieve("/movies/1234")
        assertEquals(rsp, "{\"imdbId\":\"1234\",\"title\":\"My First Movie\"}")

    }


}