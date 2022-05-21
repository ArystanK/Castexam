package kz.arctan.castexam.main.presentation

import kz.arctan.castexam.main.domain.entities.Subject


sealed interface MainIntent {
    object AddNewSubject: MainIntent
    data class OpenSubject(val subject: Subject): MainIntent
    object EditProfile: MainIntent
}