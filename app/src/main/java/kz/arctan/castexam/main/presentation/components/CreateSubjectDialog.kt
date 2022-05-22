package kz.arctan.castexam.main.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.arctan.castexam.R
import kz.arctan.castexam.common.presentation.texts.RoundedTextField
import kz.arctan.castexam.ui.theme.BlackTextBackground
import kz.arctan.castexam.ui.theme.CastexamTheme

@Composable
fun CreateSubjectDialog(
    title: String,
    onTitleChange: (String) -> Unit,
    createNewSubject: () -> Unit
) {
    Card(
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier
            .width(248.dp)
            .height(128.dp),
        shape = RoundedCornerShape(18.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Card(
                shape = RoundedCornerShape(8.dp),
                backgroundColor = BlackTextBackground
            ) {
                Text(
                    text = stringResource(id = R.string.creating_a_subject),
                    fontWeight = FontWeight.Black,
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
                )
            }
            Text(
                text = stringResource(id = R.string.come_up_with_a_title),
                fontWeight = FontWeight.Light,
                fontSize = 10.sp
            )
            RoundedTextField(value = title, onValueChange = onTitleChange)
            Button(
                onClick = createNewSubject,
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.height(24.dp),
                contentPadding = PaddingValues(vertical = 0.dp, horizontal = 22.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.create),
                    fontWeight = FontWeight.Light,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateSubjectDialogPreview() {
    CastexamTheme {
        CreateSubjectDialog("Kazakh language", onTitleChange = {}) {}
    }
}