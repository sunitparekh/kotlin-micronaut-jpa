package com.tw

import io.kotlintest.shouldBe
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class WelcomeControllerTests {

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun `hello greeting test`() {
        val result = client.toBlocking().retrieve("/hello")
        result shouldBe "Hello World !!!"
    }
}