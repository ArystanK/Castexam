package kz.arctan.castexam.login.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Snackbar
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kz.arctan.castexam.R
import kz.arctan.castexam.common.presentation.images.RoundedImage
import kz.arctan.castexam.common.presentation.texts.TitleText
import kz.arctan.castexam.Navigation.MAIN_SCREEN
import kz.arctan.castexam.common.presentation.buttons.BackButton
import kz.arctan.castexam.common.presentation.buttons.LoginButton
import kz.arctan.castexam.common.presentation.texts.TextFieldWithIcon

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        LoginView(
            username = viewModel.loginUiState.username,
            password = viewModel.loginUiState.password,
            onLogin = {
                viewModel.acceptIntent(LoginIntent.Login)
            },
            onBack = { navController.popBackStack() },
            onUsernameChange = { viewModel.acceptIntent(LoginIntent.UsernameChange(it)) },
            onPasswordChange = { viewModel.acceptIntent(LoginIntent.PasswordChange(it)) },
            showCircleProgressIndicator = viewModel.loginUiState.isLoading,
            showErrorSnackBar = viewModel.loginUiState.loginState == false
        )
        if (viewModel.loginUiState.loginState == true) {
            navController.navigate(MAIN_SCREEN)
        }
    }
}

@Composable
fun LoginView(
    username: String,
    password: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLogin: () -> Unit,
    onBack: () -> Unit,
    showCircleProgressIndicator: Boolean,
    showErrorSnackBar: Boolean
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        TitleText()
        RoundedImage(
            image = painterResource(id = R.drawable.login_image),
            modifier = Modifier
                .height(260.dp)
        )
        Text(
            text = stringResource(id = R.string.log_in).uppercase(),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 32.sp
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
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
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            LoginButton(onLogin = onLogin, modifier = Modifier.width(250.dp))
            BackButton(onBack = onBack)
        }

        if (showErrorSnackBar) Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Snackbar {
                Text(text = "Some error occurred. Try again")
            }
        }
    }
    if (showCircleProgressIndicator) CircularProgressIndicator()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    LoginView(
        username = username,
        password = password,
        onPasswordChange = { password = it },
        onUsernameChange = { username = it },
        onBack = {},
        onLogin = {},
        showCircleProgressIndicator = true,
        showErrorSnackBar = true
    )
}