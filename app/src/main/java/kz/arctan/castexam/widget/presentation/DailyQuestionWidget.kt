package kz.arctan.castexam.widget.presentation


import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.datastore.preferences.core.Preferences
import androidx.glance.GlanceModifier
import androidx.glance.LocalContext
import androidx.glance.action.Action
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.appWidgetBackground
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.state.GlanceStateDefinition
import androidx.glance.state.PreferencesGlanceStateDefinition
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import kz.arctan.castexam.R
import kz.arctan.castexam.widget.presentation.components.Option
import kz.arctan.castexam.widget.presentation.components.TitleText

class DailyQuestionWidget : GlanceAppWidget() {

    @Composable
    override fun Content() {
        val prefs = currentState<Preferences>()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = GlanceModifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .appWidgetBackground(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TitleText(
                title = LocalContext.current.getString(R.string.daily_question),
                backgroundColor = Color.Black
            )
//            Text(text = prefs[stringPreferencesKey(question)] ?: "")
            Text(
                text = "What is Your name?",
                style = TextStyle(
                    color = ColorProvider(
                        contentColorFor(
                            backgroundColor = MaterialTheme.colors.background
                        )
                    )
                )
            )
            Option(text = "Arman", onClick = object : Action {})
            Option(text = "Nurlan", onClick = object : Action {})
        }

    }

    override val stateDefinition: GlanceStateDefinition<*> = PreferencesGlanceStateDefinition
}

class DailyQuestionWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget = DailyQuestionWidget()

}