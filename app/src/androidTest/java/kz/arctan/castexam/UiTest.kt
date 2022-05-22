package kz.arctan.castexam

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import kz.arctan.castexam.common.presentation.buttons.LoginButton
import kz.arctan.castexam.common.presentation.buttons.RegisterButton
import kz.arctan.castexam.common.presentation.texts.TextFieldWithIcon

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class UiTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun passwordTextFieldExists() {
        composeTestRule.setContent {
            var password by remember { mutableStateOf("") }
            TextFieldWithIcon(
                value = password,
                onValueChange = { password = it },
                icon = Icons.Default.Lock,
                placeHolder = stringResource(id = R.string.password)
            )
        }
        composeTestRule.onNodeWithText("Password").assertExists()
    }

    @Test
    fun loginButtonExists() {
        composeTestRule.setContent {
            LoginButton {}
        }

        composeTestRule.onNodeWithText("Log in", ignoreCase = true).assertExists()
    }

    @Test
    fun registrationButtonExists() {
        composeTestRule.setContent {
            RegisterButton {}
        }
        composeTestRule.onNodeWithText("Register", ignoreCase = true).assertExists()
    }

    @Test
    fun registrationButtonIsClickable() {
        composeTestRule.setContent {
            RegisterButton {}
        }
        composeTestRule.onNodeWithText("Register", ignoreCase = true).assertHasClickAction()
    }

    @Test
    fun loginButtonIsClickable() {
        composeTestRule.setContent {
            LoginButton {}
        }
        composeTestRule.onNodeWithText("Log in", ignoreCase = true).assertHasClickAction()
    }
}