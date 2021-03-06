package kz.arctan.castexam.common.presentation.buttons

import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.arctan.castexam.R
import kz.arctan.castexam.ui.theme.Blue

@Composable
fun RegisterButton(
    modifier: Modifier = Modifier,
    onRegister: () -> Unit
) {
    DefaultButton(
        text = stringResource(id = R.string.register),
        onClick = onRegister,
        leadingIcon = Icons.Default.PersonAdd,
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = modifier,
        contentColor = Color.White
    )
}

@Preview
@Composable
fun RegisterButtonPreview() {
    RegisterButton(modifier = Modifier.width(200.dp)) {

    }
}