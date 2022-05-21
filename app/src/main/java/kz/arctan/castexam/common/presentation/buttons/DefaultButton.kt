package kz.arctan.castexam.common.presentation.buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun DefaultButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    leadingIcon: ImageVector,
    backgroundColor: Color
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = Color.White
        ),
        modifier = modifier,
        elevation = ButtonDefaults.elevation(defaultElevation = 8.dp)
    ) {
        Icon(leadingIcon, contentDescription = text)
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(text = text)
        }
    }
}