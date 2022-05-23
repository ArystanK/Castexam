package kz.arctan.castexam.main.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kz.arctan.castexam.R
import kz.arctan.castexam.main.domain.entities.Subject
import kz.arctan.castexam.main.presentation.components.CreateSubjectDialog
import kz.arctan.castexam.main.presentation.components.NewSubjectTile
import kz.arctan.castexam.main.presentation.components.SubjectTile
import kz.arctan.castexam.main.presentation.components.UserInfoTopBar
import kz.arctan.castexam.ui.theme.CastexamTheme

@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel = viewModel()
) {
    MainView(
        username = mainViewModel.mainUiState.username,
        name = mainViewModel.mainUiState.name,
        surname = mainViewModel.mainUiState.surname,
        subjects = mainViewModel.mainUiState.subjects,
        openSettings = { mainViewModel.acceptIntent(MainIntent.OpenSettings) },
        onAddNewSubject = { mainViewModel.acceptIntent(MainIntent.AddNewSubject) },
        onOpenSubjectDetail = { mainViewModel.acceptIntent(MainIntent.OpenSubject(it)) }
    )
    if (mainViewModel.mainUiState.showCreateSubjectDialog) {
        Dialog(onDismissRequest = { mainViewModel.acceptIntent(MainIntent.DismissDialog) }) {
            CreateSubjectDialog(
                title = mainViewModel.mainUiState.newSubjectTitle,
                onTitleChange = { mainViewModel.acceptIntent(MainIntent.NewSubjectTitleChange(it)) },
                createNewSubject = { mainViewModel.acceptIntent(MainIntent.CreateNewSubject) }
            )
        }
    }
}

@Composable
fun MainView(
    username: String,
    name: String,
    surname: String,
    openSettings: () -> Unit,
    subjects: List<Subject>,
    onAddNewSubject: () -> Unit,
    onOpenSubjectDetail: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        UserInfoTopBar(
            username = username,
            name = name,
            surname = surname,
            openSettings = openSettings
        )
        Text(
            text = stringResource(id = R.string.subjects),
            color = contentColorFor(backgroundColor = MaterialTheme.colors.background),
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    NewSubjectTile(onAddNewSubject = onAddNewSubject)
                    if (subjects.isNotEmpty())
                        SubjectTile(
                            title = subjects.first().title,
                            numberOfTests = subjects.first().numberOfTests,
                            numberOfQuestions = subjects.first().numberOfQuestions,
                            onOpenDetail = { onOpenSubjectDetail(subjects.first().id) }
                        )
                }
            }
            if (subjects.size >= 2)
                items(items = (1 until subjects.lastIndex).toList()) { id ->
                    if (id % 2 != 0)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            var currentSubject = subjects[id]
                            SubjectTile(
                                title = currentSubject.title,
                                numberOfTests = currentSubject.numberOfTests,
                                numberOfQuestions = currentSubject.numberOfQuestions,
                                onOpenDetail = { onOpenSubjectDetail(currentSubject.id) }
                            )
                            if (id + 1 in subjects.indices) {
                                currentSubject = subjects[id + 1]
                                SubjectTile(
                                    title = currentSubject.title,
                                    numberOfTests = currentSubject.numberOfTests,
                                    numberOfQuestions = currentSubject.numberOfQuestions,
                                    onOpenDetail = { onOpenSubjectDetail(currentSubject.id) }
                                )
                            }
                        }
                }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    CastexamTheme {
        MainView(
            username = "Arctan",
            name = "Arystan",
            surname = "Kalmakhanov",
            subjects = listOf(
                Subject(
                    id = 0,
                    title = "History",
                    numberOfQuestions = 289,
                    numberOfTests = 3
                ),
                Subject(
                    id = 1,
                    title = "Math",
                    numberOfTests = 4,
                    numberOfQuestions = 453
                ),
                Subject(
                    id = 2,
                    title = "English",
                    numberOfQuestions = 171,
                    numberOfTests = 2
                )
            ),
            openSettings = {},
            onOpenSubjectDetail = {},
            onAddNewSubject = {}
        )
    }
}