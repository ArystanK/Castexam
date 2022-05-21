package kz.arctan.castexam.start.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.arctan.castexam.common.presentation.buttons.LoginButton
import kz.arctan.castexam.common.presentation.buttons.RegisterButton
import kz.arctan.castexam.common.presentation.texts.TitleText

@Composable
fun StartScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TitleText(modifier = Modifier.weight(3F))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.weight(1f)
        ) {
            LoginButton(
                modifier = Modifier.width(200.dp),
                onLogin = {
                    // TODO: navigate to login screen
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            RegisterButton(
                modifier = Modifier.width(200.dp),
                onRegister = {
                    // TODO: navigate to registration screen
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    StartScreen()
}