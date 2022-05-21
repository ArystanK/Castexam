package kz.arctan.castexam.register.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.arctan.castexam.R
import kz.arctan.castexam.common.presentation.images.RoundedImage
import androidx.lifecycle.viewmodel.compose.viewModel
import kz.arctan.castexam.common.presentation.buttons.DefaultButton
import kz.arctan.castexam.common.presentation.buttons.RegisterButton
import kz.arctan.castexam.common.presentation.texts.TextFieldWithIcon

@Composable
fun RegistrationScreen(viewModel: RegistrationViewModel = viewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        RoundedImage(
            image = painterResource(id = R.drawable.registration_image),
            modifier = Modifier
                .scale(0.9f)
                .height(350.dp)
        )
        Text(
            text = stringResource(id = R.string.register),
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.ExtraBold,
        )
        TextFieldWithIcon(
            value = viewModel.uiState.name,
            onValueChange = { viewModel.acceptIntent(RegistrationIntent.NameChange(it)) },
            icon = Icons.Default.Add,
            placeHolder = stringResource(id = R.string.name)
        )
        TextFieldWithIcon(
            value = viewModel.uiState.surname,
            onValueChange = { viewModel.acceptIntent(RegistrationIntent.SurnameChange(it)) },
            icon = Icons.Default.Add,
            placeHolder = stringResource(id = R.string.surname)
        )
        TextFieldWithIcon(
            value = viewModel.uiState.username,
            onValueChange = { viewModel.acceptIntent(RegistrationIntent.UsernameChange(it)) },
            icon = Icons.Default.Person,
            placeHolder = stringResource(id = R.string.username)
        )
        TextFieldWithIcon(
            value = viewModel.uiState.password,
            onValueChange = { viewModel.acceptIntent(RegistrationIntent.PasswordChange(it)) },
            icon = Icons.Default.Lock,
            placeHolder = stringResource(id = R.string.password),
        )
        Column {
            RegisterButton(
                onRegister = { viewModel.acceptIntent(RegistrationIntent.Register) },
                modifier = Modifier.width(250.dp)
            )
            DefaultButton(
                text = stringResource(id = R.string.back),
                onClick = { viewModel.acceptIntent(RegistrationIntent.GoBack) },
                leadingIcon = Icons.Default.ArrowBack,
                backgroundColor = Color.Black,
                modifier = Modifier.width(250.dp)
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen()
}