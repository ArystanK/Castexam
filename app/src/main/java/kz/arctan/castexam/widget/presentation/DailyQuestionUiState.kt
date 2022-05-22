package kz.arctan.castexam.widget.presentation

import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import kz.arctan.castexam.R
import kz.arctan.castexam.common.domain.entities.Question

data class DailyQuestionUiState(
    val isAnswered: Pair<Boolean, Boolean> = false to false,
    @StringRes val title: Int = R.string.daily_question,
    val question: Question? = null
)
