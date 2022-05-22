package kz.arctan.castexam.widget.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.cornerRadius
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider

@Composable
fun TitleText(
    title: String,
    backgroundColor: Color
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = GlanceModifier
            .background(backgroundColor)
            .cornerRadius(24.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = ColorProvider(Color.White)
            ),
            modifier = GlanceModifier
                .padding(horizontal = 16.dp)
                .cornerRadius(24.dp)
        )
    }
}
