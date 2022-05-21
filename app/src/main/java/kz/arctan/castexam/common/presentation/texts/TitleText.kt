package kz.arctan.castexam.common.presentation.texts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import kz.arctan.castexam.R
import kz.arctan.castexam.ui.theme.TitleGreen
import java.util.*

@Composable
fun TitleText(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.app_name).replaceFirstChar { it.lowercase(Locale.ROOT) },
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.ExtraBold,
            color = TitleGreen
        )
        Text(text = stringResource(id = R.string.create_and_practice))
    }
}