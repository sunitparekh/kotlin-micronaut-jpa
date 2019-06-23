package com.tw

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class WelcomeController {

    @Get("hello")
    fun hello() = "Hello World !!!"

}