package kz.arctan.castexam

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import kz.arctan.castexam.login.presentation.LoginScreen
import kz.arctan.castexam.main.presentation.MainScreen
import kz.arctan.castexam.register.presentation.RegisterScreen
import kz.arctan.castexam.start.presentation.StartScreen
import kz.arctan.castexam.ui.theme.CastexamTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MAIN_ACTIVITY", "ON_CREATE")

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

    override fun onStart() {
        Log.d("MAIN_ACTIVITY", "ON_START")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MAIN_ACTIVITY", "ON_RESUME")
        super.onResume()
    }


    override fun onPause() {
        Log.d("MAIN_ACTIVITY", "ON_PAUSE")
        super.onPause()
    }

    override fun onStop() {
        Log.d("MAIN_ACTIVITY", "ON_STOP")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MAIN_ACTIVITY", "ON_DESTROY")
        super.onDestroy()
    }
}