package kz.arctan.castexam.main.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.arctan.castexam.R
import kz.arctan.castexam.ui.theme.CastexamTheme
import kz.arctan.castexam.ui.theme.Grey

@Composable
fun UserInfoTopBar(
    username: String,
    name: String,
    surname: String,
    openSettings: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(16.dp)) {
            Column {
                Text(
                    text = stringResource(id = R.string.greetings, username),
                    style = MaterialTheme.typography.caption,
                    color = Grey
                )
                Text(text = "$name $surname")
            }
            IconButton(onClick = openSettings) {
                Card(
                    backgroundColor = MaterialTheme.colors.primary,
                    modifier = Modifier.scale(1.2f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = stringResource(id = R.string.open_settings),
                        modifier = Modifier.padding(2.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun UserInfoTopBarPreview() {
    CastexamTheme {
        UserInfoTopBar(username = "Arctan", name = "Arystan", surname = "Kalmakhanov") {}
    }
}