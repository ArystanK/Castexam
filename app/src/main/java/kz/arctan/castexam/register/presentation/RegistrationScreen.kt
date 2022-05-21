package kz.arctan.castexam.register.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kz.arctan.castexam.Navigation.LOGIN_SCREEN
import kz.arctan.castexam.R
import kz.arctan.castexam.common.presentation.buttons.BackButton
import kz.arctan.castexam.common.presentation.buttons.DefaultButton
import kz.arctan.castexam.common.presentation.buttons.RegisterButton
import kz.arctan.castexam.common.presentation.images.RoundedImage
import kz.arctan.castexam.common.presentation.texts.TextFieldWithIcon
import kz.arctan.castexam.ui.theme.CastexamTheme

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegistrationViewModel = viewModel()
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        RegistrationView(
            name = viewModel.uiState.name,
            onNameChange = { viewModel.acceptIntent(RegistrationIntent.NameChange(it)) },
            surname = viewModel.uiState.surname,
            onSurnameChange = { viewModel.acceptIntent(RegistrationIntent.SurnameChange(it)) },
            username = viewModel.uiState.username,
            onUsernameChange = { viewModel.acceptIntent(RegistrationIntent.UsernameChange(it)) },
            password = viewModel.uiState.password,
            onPasswordChange = { viewModel.acceptIntent(RegistrationIntent.PasswordChange(it)) },
            register = { viewModel.acceptIntent(RegistrationIntent.Register) },
            navigateToStartScreen = { navController.popBackStack() },
            navigateToLoginScreen = { navController.navigate(LOGIN_SCREEN) }
        )
    }
}

@Composable
fun RegistrationView(
    name: String,
    onNameChange: (String) -> Unit,
    surname: String,
    onSurnameChange: (String) -> Unit,
    username: String,
    onUsernameChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    register: () -> Unit,
    navigateToStartScreen: () -> Unit,
    navigateToLoginScreen: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        RoundedImage(
            image = painterResource(id = R.drawable.registration_image),
            modifier = Modifier
                .height(260.dp)
        )
        Text(
            text = stringResource(id = R.string.register),
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.ExtraBold,
        )
        TextFieldWithIcon(
            value = name,
            onValueChange = onNameChange,
            icon = Icons.Default.Badge,
            placeHolder = stringResource(id = R.string.name)
        )
        TextFieldWithIcon(
            value = surname,
            onValueChange = onSurnameChange,
            icon = Icons.Default.Badge,
            placeHolder = stringResource(id = R.string.surname)
        )
        TextFieldWithIcon(
            value = username,
            onValueChange = onUsernameChange,
            icon = Icons.Default.AccountCircle,
            placeHolder = stringResource(id = R.string.username)
        )
        TextFieldWithIcon(
            value = password,
            onValueChange = onPasswordChange,
            icon = Icons.Default.Lock,
            placeHolder = stringResource(id = R.string.password),
            isPassword = true
        )
        Column {
            RegisterButton(
                onRegister = { register(); navigateToLoginScreen() },
                modifier = Modifier.width(250.dp)
            )
            BackButton(onBack = navigateToStartScreen)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegistrationScreenPreview() {
    CastexamTheme {
        RegistrationView(
            name = "",
            onNameChange = {},
            surname = "",
            onSurnameChange = {},
            username = "",
            onUsernameChange = {},
            password = "",
            onPasswordChange = {},
            register = { /*TODO*/ },
            navigateToStartScreen = { /*TODO*/ }) {

        }
    }
}