package com.mungai_codes.mycv.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mungai_codes.mycv.domain.model.Education
import com.mungai_codes.mycv.domain.model.PersonalInfo
import com.mungai_codes.mycv.domain.model.Skill
import com.mungai_codes.mycv.domain.model.Work
import com.mungai_codes.mycv.presentation.cvscreen.CvScreenEvents
import com.mungai_codes.mycv.presentation.cvscreen.CvScreenUiEvents
import com.mungai_codes.mycv.presentation.editscreen.EditScreenEvents
import com.mungai_codes.mycv.presentation.editscreen.EditScreenUiEvents
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _state = MutableStateFlow(AppUiState())
    val state = _state.asStateFlow()

    private val _cvScreenUiEventsMutableSharedFlow = MutableSharedFlow<CvScreenUiEvents>()
    val cvScreenUiEventsSharedFlow = _cvScreenUiEventsMutableSharedFlow.asSharedFlow()

    private val _editScreenUiEventsMutableSharedFlow = MutableSharedFlow<EditScreenUiEvents>()
    val editScreenUiEventsSharedFlow = _editScreenUiEventsMutableSharedFlow.asSharedFlow()

    fun onCvScreenEvent(cvScreenEvent: CvScreenEvents) {
        when (cvScreenEvent) {
            CvScreenEvents.OnEditCvEvent -> {
                viewModelScope.launch {
                    _cvScreenUiEventsMutableSharedFlow.emit(CvScreenUiEvents.NavigateToEditCvScreen)
                }
            }

            is CvScreenEvents.OnSectionClickedEvent -> {
                viewModelScope.launch {
                    _cvScreenUiEventsMutableSharedFlow.emit(
                        CvScreenUiEvents.ExpandSection(
                            cvScreenEvent.section
                        )
                    )
                }
            }
        }
    }

    fun onEditScreenEvent(editScreenEvent: EditScreenEvents) {
        when (editScreenEvent) {
            EditScreenEvents.OnDoneEditingEvent -> {
                viewModelScope.launch {
                    _editScreenUiEventsMutableSharedFlow.emit(EditScreenUiEvents.NavigateToCvScreen)
                }
            }

            is EditScreenEvents.EditBioEvent -> {
                editBio(editScreenEvent.text)
            }

            is EditScreenEvents.EditSkillsEvent -> {
                updateSkill(editScreenEvent.skillName, editScreenEvent.skill)
            }

            is EditScreenEvents.EditEducationEvent -> {
                updateEducation(editScreenEvent.institution, editScreenEvent.education)
            }
        }
    }

    private fun editBio(input: String) {
        _state.update {
            it.copy(
                personalInfo = PersonalInfo(
                    fullName = _state.value.personalInfo.fullName,
                    bio = input
                )
            )
        }
    }

    private fun updateEducation(institution: String, updatedEducation: Education) {
        _state.update { currentState ->
            val updatedEducationCredentials = currentState.education.map { education ->
                if (education.institution == institution) {
                    education.copy(
                        institution = updatedEducation.institution,
                        from = updatedEducation.from,
                        to = updatedEducation.to,
                        qualification = updatedEducation.qualification,
                        grade = updatedEducation.grade
                    )
                } else {
                    education
                }
            }
            currentState.copy(education = updatedEducationCredentials)
        }
    }


    private fun updateSkill(skillName: String, updatedSkill: Skill) {
        _state.update { currentState ->
            val updatedSkills = currentState.skills.map { skill ->
                if (skill.skillName == skillName) {
                    skill.copy(
                        skillName = updatedSkill.skillName,
                        description = updatedSkill.description
                    )
                } else {
                    skill
                }
            }
            currentState.copy(skills = updatedSkills)
        }
    }

    fun toggleBioSection() {
        _state.update { it.copy(expandBioSection = !_state.value.expandBioSection) }
    }

    fun toggleWorkExperienceSection() {
        _state.update { it.copy(expandWorkExperienceSection = !_state.value.expandWorkExperienceSection) }
    }

    fun toggleEducationSection() {
        _state.update { it.copy(expandEducationSection = !_state.value.expandEducationSection) }
    }

    fun toggleSkillsSection() {
        _state.update { it.copy(expandSkillsSection = !_state.value.expandSkillsSection) }
    }

    fun toggleSocialsSection() {
        _state.update { it.copy(expandSocialsSection = !_state.value.expandSocialsSection) }
    }
}