package kz.arctan.castexam.main.presentation

sealed interface MainIntent {
    object AddNewSubject: MainIntent
    data class OpenSubject(val id: Int): MainIntent
    object OpenSettings: MainIntent
    object DismissDialog: MainIntent
    data class NewSubjectTitleChange(val title: String) : MainIntent
    object CreateNewSubject: MainIntent
}