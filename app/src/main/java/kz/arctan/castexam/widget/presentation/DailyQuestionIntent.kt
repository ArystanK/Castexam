package kz.arctan.castexam.widget.presentation

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.action.ActionCallback

interface DailyQuestionIntent {
    data class Answer(val answerId: Int) : DailyQuestionIntent, ActionCallback {
        override suspend fun onRun(
            context: Context,
            glanceId: GlanceId,
            parameters: ActionParameters
        ) {

        }

    }
}