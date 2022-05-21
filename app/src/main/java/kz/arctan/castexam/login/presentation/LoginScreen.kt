package kz.arctan.castexam.login.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import kz.arctan.castexam.R
import kz.arctan.castexam.common.presentation.images.RoundedImage
import kz.arctan.castexam.common.presentation.texts.TitleText

@Composable
fun LoginScreen(navController: NavController) {
    LoginView()

}

@Composable
fun LoginView() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TitleText()
        RoundedImage(
            image = painterResource(id = R.drawable.login_image),
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginView()
}