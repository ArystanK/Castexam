package kz.arctan.castexam.common.presentation.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.arctan.castexam.R
import kz.arctan.castexam.ui.theme.Green

@Composable
fun LoginButton(
    modifier: Modifier = Modifier,
    onLogin: () -> Unit
) {
    DefaultButton(
        text = stringResource(id = R.string.log_in),
        onClick = onLogin,
        leadingIcon = Icons.Default.ExitToApp,
        backgroundColor = Green,
        modifier = modifier
    )
}

@Preview
@Composable
fun LoginButtonPreview() {
    LoginButton(modifier = Modifier.width(200.dp)) {

    }
}