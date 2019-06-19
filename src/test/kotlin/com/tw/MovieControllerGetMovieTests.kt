package com.tw

import io.kotlintest.matchers.shouldBe
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class MovieControllerGetMovieTests {

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun `get a movie`() {

        val movie = client.toBlocking().retrieve("/movies/1234", Movie::class.java)

        movie.imdbId shouldBe "1234"
        movie.title shouldBe "My First Movie"

    }


}