package com.example.notes.core.entity

import java.io.Serializable
import java.time.LocalDate

data class NoteModel(
    val title: String,
    val des: String
) : Serializable

