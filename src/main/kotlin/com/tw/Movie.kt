package com.tw

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "movies")
data class Movie(@Id val imdbId: String = "InvalidID", @Column val title: String = "InvalidTitle") {
}

