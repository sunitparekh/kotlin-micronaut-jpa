package com.tw

import io.kotlintest.matchers.shouldBe
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class MovieControllerGetMoviesTests {

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun `get list of movies`() {
        val request = HttpRequest.GET<Any>("/movies")
        val result = client.toBlocking().retrieve(request, Argument.of(List::class.java, Movie::class.java))

        result.size shouldBe 2
        var movie = result[0] as Movie
        movie.imdbId shouldBe "1234"
        movie.title shouldBe "My First Movie"
        movie = result[1] as Movie
        movie.imdbId shouldBe "2345"
        movie.title shouldBe "My Second Movie"
    }
}