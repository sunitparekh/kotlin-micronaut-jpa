package com.tw

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class MovieControllerGetMoviesTests {

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun `get list of movies`() {

        val rsp: String = client.toBlocking().retrieve("/movies")
        assertEquals(rsp, "[{\"imdbId\":\"1234\",\"title\":\"My First Movie\"},{\"imdbId\":\"2345\",\"title\":\"My Second Movie\"}]")

    }
}