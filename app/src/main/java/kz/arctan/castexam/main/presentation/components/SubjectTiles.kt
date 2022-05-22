package kz.arctan.castexam.main.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.Login
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.decapitalize
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.arctan.castexam.R
import kz.arctan.castexam.ui.theme.CastexamTheme
import kz.arctan.castexam.ui.theme.Gray
import kz.arctan.castexam.ui.theme.Inter
import java.util.*

@Composable
fun SubjectTile(
    title: String,
    numberOfTests: Int,
    numberOfQuestions: Int,
    onOpenDetail: () -> Unit
) {
    Card(
        modifier = Modifier
            .height(192.dp)
            .width(144.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = title)
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = numberOfTests.toString(), fontWeight = FontWeight.SemiBold)
                Text(
                    text = stringResource(id = R.string.tests).replaceFirstChar { it.lowercase() },
                    style = MaterialTheme.typography.caption,
                    fontWeight = FontWeight.Light
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = numberOfQuestions.toString(), fontWeight = FontWeight.SemiBold)
                Text(
                    text = stringResource(id = R.string.questions).replaceFirstChar { it.lowercase() },
                    style = MaterialTheme.typography.caption,
                    fontWeight = FontWeight.Light
                )
            }
            Button(
                onClick = onOpenDetail,
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.height(32.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = stringResource(id = R.string.open),
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp
                    )
                    Icon(
                        imageVector = Icons.Default.Login,
                        contentDescription = stringResource(id = R.string.open),
                        modifier = Modifier.scale(0.55f)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SubjectTilePreview() {
    CastexamTheme {
        SubjectTile(title = "Math", numberOfTests = 20, numberOfQuestions = 2000) {

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NewSubjectTile(
    onAddNewSubject: () -> Unit
) {
    Card(
        modifier = Modifier
            .height(192.dp)
            .width(144.dp),
        shape = RoundedCornerShape(16.dp),
        onClick = onAddNewSubject,
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.AddCircleOutline,
                contentDescription = stringResource(id = R.string.add_new_subject),
                tint = Gray,
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = stringResource(id = R.string.add_new_subject),
                fontWeight = FontWeight.SemiBold,
                color = Gray
            )
            Image(
                painter = painterResource(id = R.drawable.add_new_subject_background),
                contentDescription = stringResource(id = R.string.add_new_subject),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(120.dp)
                    .width(96.dp)
            )
        }
    }
}

@Preview
@Composable
fun NewSubjectTilePreview() {
    NewSubjectTile() {}
}