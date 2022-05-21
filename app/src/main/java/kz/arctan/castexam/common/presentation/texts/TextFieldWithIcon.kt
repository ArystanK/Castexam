package kz.arctan.castexam.common.presentation.texts

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldWithIcon(
    value: String,
    onValueChange: (String) -> Unit,
    icon: ImageVector,
    placeHolder: String
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = placeHolder)
        },
        placeholder = {
            Text(
                text = placeHolder,
                textAlign = TextAlign.End,
            )
        },
        shape = RoundedCornerShape(12.dp),
        textStyle = TextStyle(
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.None
        ),
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
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
        placeHolder = "Username"
    )
}