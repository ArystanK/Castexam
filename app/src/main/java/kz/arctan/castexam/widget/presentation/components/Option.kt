package kz.arctan.castexam.widget.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.GlanceModifier
import androidx.glance.action.Action
import androidx.glance.appwidget.cornerRadius
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width

@Composable
fun Option(text: String, onClick: Action) {
    Button(
        text = text,
        onClick = onClick,
        modifier = GlanceModifier
            .width(200.dp)
            .height(32.dp)
            .padding(4.dp)
            .cornerRadius(24.dp),
    )
}