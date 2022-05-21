package kz.arctan.castexam.common.presentation.texts

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DisabledVisible
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.arctan.castexam.R

@Composable
fun TextFieldWithIcon(
    value: String,
    onValueChange: (String) -> Unit,
    icon: ImageVector,
    placeHolder: String,
    isPassword: Boolean = false
) {
    var isVisible by remember { mutableStateOf(!isPassword) }
    TextField(
        value = value,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = placeHolder)
        },
        placeholder = {
            Text(
                text = placeHolder,
                fontSize = 14.sp
            )
        },
        shape = RoundedCornerShape(12.dp),
        textStyle = TextStyle(
            textDecoration = TextDecoration.None,
            fontSize = 14.sp
        ),
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = if (isPassword) {
            {
                IconButton(onClick = { isVisible = !isVisible }) {
                    if (isVisible) Icon(
                        imageVector = Icons.Default.VisibilityOff,
                        contentDescription = stringResource(id = R.string.show_password)
                    ) else Icon(
                        imageVector = Icons.Default.Visibility,
                        contentDescription = stringResource(id = R.string.show_password)
                    )
                }
            }
        } else null,
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text
        ),
        modifier = Modifier.height(48.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldWithIconPreview() {
    var username by remember { mutableStateOf("") }
    TextFieldWithIcon(
        value = username,
        onValueChange = { username = it },
        icon = Icons.Filled.Person,
        placeHolder = "Username",
        isPassword = true
    )
}