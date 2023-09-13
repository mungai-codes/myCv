package com.mungai_codes.mycv.presentation.cvscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mungai_codes.mycv.R
import com.mungai_codes.mycv.presentation.AppUiState
import com.mungai_codes.mycv.presentation.MainViewModel
import com.mungai_codes.mycv.presentation.cvscreen.components.EducationItem
import com.mungai_codes.mycv.presentation.cvscreen.components.SectionItem
import com.mungai_codes.mycv.presentation.cvscreen.components.SocialItem
import com.mungai_codes.mycv.presentation.cvscreen.components.WorkItem
import com.mungai_codes.mycv.presentation.util.Section
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CvScreen(navController: NavController, viewModel: MainViewModel) {

    LaunchedEffect(key1 = true) {
        viewModel.cvScreenUiEventsSharedFlow.collectLatest { event ->
            when (event) {
                is CvScreenUiEvents.ExpandSection -> {
                    when (event.section) {
                        Section.BioSection -> {
                            viewModel.toggleBioSection()
                        }

                        Section.EducationSection -> {
                            viewModel.toggleEducationSection()
                        }

                        Section.SkillsSection -> {
                            viewModel.toggleSkillsSection()
                        }

                        Section.SocialsSection -> {
                            viewModel.toggleSocialsSection()
                        }

                        Section.WorkExperienceSection -> {
                            viewModel.toggleWorkExperienceSection()
                        }
                    }
                }

                CvScreenUiEvents.NavigateToEditCvScreen -> {
                    navController.navigate("edit_screen")
                }
            }
        }
    }

    CvScreenContent(
        state = viewModel.state.collectAsState().value,
        onEvent = viewModel::onCvScreenEvent
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CvScreenContent(state: AppUiState, onEvent: (CvScreenEvents) -> Unit) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { onEvent(CvScreenEvents.OnEditCvEvent) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_edit),
                    contentDescription = "edit cv",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding()
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = state.personalInfo.fullName,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        lineBreak = LineBreak.Heading
                    )
                )
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                item {
                    SectionItem(title = "Bio",
                        imageResourceId = R.drawable.ic_bio,
                        expanded = state.expandBioSection,
                        onClick = { onEvent(CvScreenEvents.OnSectionClickedEvent(Section.BioSection)) },
                        content = {
                            Text(
                                text = state.personalInfo.bio,
                                textAlign = TextAlign.Start,
                                fontSize = 12.sp,
                                fontFamily = FontFamily.Serif
                            )
                        }
                    )
                }

                item {
                    SectionItem(
                        title = "Work Experience",
                        imageResourceId = R.drawable.ic_work_experience,
                        expanded = state.expandWorkExperienceSection,
                        onClick = { onEvent(CvScreenEvents.OnSectionClickedEvent(Section.WorkExperienceSection)) },
                        content = {
                            state.workExperience.forEach { work ->
                                WorkItem(work = work)
                            }
                        }
                    )
                }

                item {
                    SectionItem(
                        title = "Education",
                        imageResourceId = R.drawable.ic_education,
                        expanded = state.expandEducationSection,
                        onClick = { onEvent(CvScreenEvents.OnSectionClickedEvent(Section.EducationSection)) },
                        content = {
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                state.education.forEach { education ->
                                    EducationItem(education = education)
                                }
                            }
                        }
                    )
                }

                item {
                    SectionItem(title = "Skills",
                        imageResourceId = R.drawable.ic_skills,
                        expanded = state.expandSkillsSection,
                        onClick = { onEvent(CvScreenEvents.OnSectionClickedEvent(Section.SkillsSection)) },
                        content = {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(2.dp)
                            ) {
                                state.skills.forEach { skill ->
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .padding(start = 16.dp, end = 8.dp)
                                                .size(4.dp)
                                                .background(
                                                    MaterialTheme.colorScheme.onBackground,
                                                    shape = CircleShape
                                                )
                                        )
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Text(
                                                text = skill.skillName,
                                                fontFamily = FontFamily.Serif,
                                                fontSize = 12.sp
                                            )
                                            Spacer(modifier = Modifier.width(2.dp))
                                            skill.description?.let { desc ->
                                                Text(
                                                    text = "($desc)",
                                                    fontFamily = FontFamily.Serif,
                                                    fontSize = 12.sp
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    )
                }

                item {
                    SectionItem(title = "Socials",
                        imageResourceId = R.drawable.ic_social,
                        expanded = state.expandSocialsSection,
                        onClick = { onEvent(CvScreenEvents.OnSectionClickedEvent(Section.SocialsSection)) },
                        content = {
                            FlowRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                state.socials.forEach { social ->
                                    SocialItem(social = social)
                                }
                            }
                        }
                    )
                }

            }
        }

    }
}