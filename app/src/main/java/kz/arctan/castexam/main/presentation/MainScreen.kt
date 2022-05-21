package kz.arctan.castexam.main.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel = viewModel()
) {
    MainView()
}

@Composable
fun MainView() {

}

@Preview
@Composable
fun MainViewPreview() {
    MainView()
}