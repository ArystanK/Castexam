package kz.arctan.castexam.common.presentation.texts

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.arctan.castexam.ui.theme.Black
import kz.arctan.castexam.ui.theme.Gray

@Composable
fun RoundedTextField(value: String, onValueChange: (String) -> Unit) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
//        shape = RoundedCornerShape(12.dp),
        textStyle = TextStyle(
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Light,
            color = Color.White
        ),
        singleLine = true,
//        colors = TextFieldDefaults.textFieldColors(
//            disabledIndicatorColor = Color.Transparent,
//            errorIndicatorColor = Color.Transparent,
//            focusedIndicatorColor = Color.Transparent,
//            unfocusedIndicatorColor = Color.Transparent
//        ),
        modifier = Modifier
            .height(32.dp)
            .width(216.dp),
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            backgroundColor = if (isSystemInDarkTheme()) Black else Gray,
            elevation = 0.dp,
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                it()
            }
        }
    }
}