package kz.arctan.castexam.start.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kz.arctan.castexam.Navigation.LOGIN_SCREEN
import kz.arctan.castexam.Navigation.REGISTRATION_SCREEN
import kz.arctan.castexam.common.presentation.buttons.LoginButton
import kz.arctan.castexam.common.presentation.buttons.RegisterButton
import kz.arctan.castexam.common.presentation.texts.TitleText

@Composable
fun StartScreen(navController: NavController) {
    StartView(
        navigateToLoginScreen = { navController.navigate(LOGIN_SCREEN) },
        navigateToRegistrationScreen = { navController.navigate(REGISTRATION_SCREEN) }
    )
}

@Composable
fun StartView(
    navigateToLoginScreen: () -> Unit,
    navigateToRegistrationScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TitleText(modifier = Modifier.weight(3F))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.weight(1f)
        ) {
            LoginButton(
                modifier = Modifier.width(200.dp),
                onLogin = navigateToLoginScreen
            )
            Spacer(modifier = Modifier.height(12.dp))
            RegisterButton(
                modifier = Modifier.width(200.dp),
                onRegister = navigateToRegistrationScreen
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    StartView(navigateToLoginScreen = { }, navigateToRegistrationScreen = { })
}