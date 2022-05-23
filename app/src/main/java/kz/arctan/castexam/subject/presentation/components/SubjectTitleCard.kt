package kz.arctan.castexam.subject.presentation.components

import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.glance.layout.Row
import kz.arctan.castexam.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SubjectTitleCard(title: String, onEditTitle: () -> Unit) {
    Card(onClick = onEditTitle) {
        Row {
            Text(text = title)
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = stringResource(id = R.string.edit)
            )
        }
    }
}