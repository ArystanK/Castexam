package kz.arctan.castexam.common.presentation.buttons

import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kz.arctan.castexam.R

@Composable
fun BackButton(
    onBack: () -> Unit
) {
    DefaultButton(
        text = stringResource(id = R.string.back),
        onClick = onBack,
        leadingIcon = Icons.Default.ArrowBack,
        backgroundColor = MaterialTheme.colors.onSecondary,
        modifier = Modifier.width(250.dp),
        contentColor = Color.White
    )
}