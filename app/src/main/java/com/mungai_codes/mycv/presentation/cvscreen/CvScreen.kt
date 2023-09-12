package com.mungai_codes.mycv.presentation.cvscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mungai_codes.mycv.R
import com.mungai_codes.mycv.presentation.cvscreen.components.SectionItem
import com.mungai_codes.mycv.presentation.util.Section
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CvScreen(navController: NavController, viewModel: CvScreenViewModel = viewModel()) {

    LaunchedEffect(key1 = true) {
        viewModel.uiEventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ExpandSection -> {
                    when (event.section) {
                        Section.BioSection -> {
                            viewModel.updateBioSection()
                        }

                        Section.EducationSection -> {
                            viewModel.updateEducationSection()
                        }

                        Section.SkillsSection -> {
                            viewModel.updateSkillsSection()
                        }

                        Section.SocialsSection -> {
                            viewModel.updateSocialsSection()
                        }

                        Section.WorkExperienceSection -> {
                            viewModel.updateWorkExperienceoSection()
                        }
                    }
                }

                UiEvent.NavigateToEditCvScreen -> {
                    navController.navigate("edit_screen")
                }
            }
        }
    }

    CvScreenContent(
        state = viewModel.state.collectAsState().value,
        onEvent = viewModel::onEvent
    )
}

@Composable
fun CvScreenContent(state: CvScreenState, onEvent: (CvScreenEvent) -> Unit) {

    Scaffold { innerPadding ->
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
                SectionItem(title = "Bio",
                    imageResourceId = R.drawable.ic_bio,
                    expanded = state.expandBioSection,
                    onClick = { onEvent(CvScreenEvent.OnSectionClickedEvent(Section.BioSection)) },
                    content = {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(text = "Random Item")
                            Text(text = "Random Item")
                            Text(text = "Random Item")
                            Text(text = "Random Item")
                        }
                    }
                )
            }

            item {
                SectionItem(
                    title = "Work Experience",
                    imageResourceId = R.drawable.ic_work_experience,
                    expanded = state.expandWorkExperienceSection,
                    onClick = { onEvent(CvScreenEvent.OnSectionClickedEvent(Section.WorkExperienceSection)) },
                    content = {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(text = "Random Item")
                            Text(text = "Random Item")
                            Text(text = "Random Item")
                            Text(text = "Random Item")
                        }
                    }
                )
            }

            item {
                SectionItem(
                    title = "Education",
                    imageResourceId = R.drawable.ic_education,
                    expanded = state.expandEducationSection,
                    onClick = { onEvent(CvScreenEvent.OnSectionClickedEvent(Section.EducationSection)) },
                    content = {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(text = "Random Item")
                            Text(text = "Random Item")
                            Text(text = "Random Item")
                            Text(text = "Random Item")
                        }
                    }
                )
            }

            item {
                SectionItem(title = "Skills",
                    imageResourceId = R.drawable.ic_skills,
                    expanded = state.expandSkillsSection,
                    onClick = { onEvent(CvScreenEvent.OnSectionClickedEvent(Section.SkillsSection)) },
                    content = {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(text = "Random Item")
                            Text(text = "Random Item")
                            Text(text = "Random Item")
                            Text(text = "Random Item")
                        }
                    }
                )
            }

            item {
                SectionItem(title = "Socials",
                    imageResourceId = R.drawable.ic_social,
                    expanded = state.expandSocialsSection,
                    onClick = { onEvent(CvScreenEvent.OnSectionClickedEvent(Section.SocialsSection)) },
                    content = {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(text = "Random Item")
                            Text(text = "Random Item")
                            Text(text = "Random Item")
                            Text(text = "Random Item")
                        }
                    }
                )
            }

        }

    }
}