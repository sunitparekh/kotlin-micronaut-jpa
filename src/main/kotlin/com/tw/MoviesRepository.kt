package com.tw

import io.micronaut.spring.tx.annotation.Transactional
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Singleton
open class MoviesRepository(@PersistenceContext private val manager: EntityManager) {

    @Transactional(readOnly = true)
    open fun findById(imdbId: String) = manager.find(Movie::class.java, imdbId)

    @Transactional(readOnly = true)
    open fun findAll() = manager
            .createQuery("from Movie", Movie::class.java).resultList
}