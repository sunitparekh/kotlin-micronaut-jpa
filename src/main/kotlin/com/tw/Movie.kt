package com.tw

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "movies")
data class Movie(@Id var imdbId: String, @Column var title: String)

