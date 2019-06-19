package com.tw

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/movies")
class MovieController(private val movies: MoviesRepository) {

    @Get("/{imdbId}")
    fun findMovies(imdbId: String)= movies.findById(imdbId)

    @Get("/")
    fun findMovies()= movies.findAll()

}