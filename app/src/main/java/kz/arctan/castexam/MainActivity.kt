package kz.arctan.castexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kz.arctan.castexam.login.presentation.LoginScreen
import kz.arctan.castexam.main.presentation.MainScreen
import kz.arctan.castexam.register.presentation.RegisterScreen
import kz.arctan.castexam.start.presentation.StartScreen
import kz.arctan.castexam.ui.theme.CastexamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CastexamTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Navigation.START_SCREEN
                ) {
                    composable(Navigation.START_SCREEN) { StartScreen(navController) }
                    composable(Navigation.LOGIN_SCREEN) { LoginScreen(navController) }
                    composable(Navigation.REGISTRATION_SCREEN) { RegisterScreen(navController) }
                    composable(Navigation.MAIN_SCREEN) { MainScreen(navController) }
                }
            }
        }
    }
}