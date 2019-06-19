package com.tw

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MovieControllerTests {

    @Test
    fun `get a movie`(){
        val embeddedServer : EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        val client : HttpClient = HttpClient.create(embeddedServer.url)

        val rsp : String = client.toBlocking().retrieve("http://localhost:8080/movies/1234")
        assertEquals(rsp, "Hello World")

    }
}