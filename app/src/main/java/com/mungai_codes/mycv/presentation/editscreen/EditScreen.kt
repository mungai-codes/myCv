package com.mungai_codes.mycv.presentation.editscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mungai_codes.mycv.R
import com.mungai_codes.mycv.presentation.AppUiState
import com.mungai_codes.mycv.presentation.MainViewModel
import com.mungai_codes.mycv.presentation.editscreen.components.BioEditItem
import com.mungai_codes.mycv.presentation.editscreen.components.EditEducationItem
import com.mungai_codes.mycv.presentation.editscreen.components.EditSkillItem
import com.mungai_codes.mycv.presentation.editscreen.components.EditSocialItem
import com.mungai_codes.mycv.presentation.editscreen.components.EditWorkExperienceItem
import kotlinx.coroutines.flow.collectLatest

@Composable
fun EditScreen(
    navController: NavController,
    viewModel: MainViewModel
) {

    LaunchedEffect(key1 = true) {
        viewModel.editScreenUiEventsSharedFlow.collectLatest { event ->
            when (event) {
                EditScreenUiEvents.NavigateToCvScreen -> {
                    navController.navigate("cv_screen")
                }
            }
        }
    }

    EditScreenContent(
        state = viewModel.state.collectAsState().value,
        onEvent = viewModel::onEditScreenEvent
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EditScreenContent(
    state: AppUiState,
    onEvent: (EditScreenEvents) -> Unit
) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Edit Your CV details",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        lineBreak = LineBreak.Heading
                    )
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { onEvent(EditScreenEvents.OnDoneEditingEvent) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_ok),
                    contentDescription = "done",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding()
                ),
            contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                BioEditItem(
                    label = "Edit your bio",
                    text = state.personalInfo.bio,
                    desc = "bio editing",
                    onEditText = { text ->
                        onEvent(
                            EditScreenEvents.EditBioEvent(text = text)
                        )
                    }
                )
            }

            item {
                Column {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Edit work experience", fontWeight = FontWeight.Light,
                            fontStyle = FontStyle.Italic,
                            fontFamily = FontFamily.Serif
                        )
                        state.workExperience.forEach { workExperience ->
                            EditWorkExperienceItem(
                                workExperience = workExperience,
                                onWorkExperienceUpdate = { editedWorkExperience ->
                                    onEvent(
                                        EditScreenEvents.EditWorkExperienceEvent(
                                            organisation = editedWorkExperience.organisation,
                                            workExperience = editedWorkExperience
                                        )
                                    )
                                }
                            )
                        }
                    }
                }
            }

            item {
                Column {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Edit education", fontWeight = FontWeight.Light,
                            fontStyle = FontStyle.Italic,
                            fontFamily = FontFamily.Serif
                        )
                        state.education.forEach { education ->
                            EditEducationItem(education = education,
                                onEducationUpdate = { editedEducation ->
                                    onEvent(
                                        EditScreenEvents.EditEducationEvent(
                                            institution = education.institution,
                                            education = editedEducation
                                        )
                                    )
                                }
                            )
                        }
                    }
                }
            }

            item {
                Column {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Edit skills", fontWeight = FontWeight.Light,
                            fontStyle = FontStyle.Italic,
                            fontFamily = FontFamily.Serif
                        )
                        state.skills.forEach { skill ->
                            EditSkillItem(
                                skill = skill,
                                onSkillUpdated = { editedSkill ->
                                    onEvent(
                                        EditScreenEvents.EditSkillsEvent(
                                            skillName = skill.skillName,
                                            skill = editedSkill
                                        )
                                    )
                                }
                            )
                        }
                    }
                }
            }

            item {
                Column {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Edit social handles", fontWeight = FontWeight.Light,
                            fontStyle = FontStyle.Italic,
                            fontFamily = FontFamily.Serif
                        )
                        FlowRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            state.socials.forEach { social ->
                                EditSocialItem(
                                    social = social,
                                    onSocialUpdate = { editedSocial ->
                                        onEvent(
                                            EditScreenEvents.EditSocialEvent(
                                                name = social.name,
                                                social = editedSocial
                                            )
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            }

        }
    }
}