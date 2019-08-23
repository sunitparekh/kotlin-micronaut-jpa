package com.tw

import io.kotlintest.shouldBe
import io.micronaut.http.HttpStatus
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
        val response = client.toBlocking()
                .exchange("/movies/1234", Movie::class.java)

        response.apply { status shouldBe HttpStatus.OK }
                .body()!!
                .apply { imdbId shouldBe "1234" }
                .apply { title shouldBe "My First Movie" }
    }


}