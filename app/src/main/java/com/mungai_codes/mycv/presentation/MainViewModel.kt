package com.mungai_codes.mycv.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mungai_codes.mycv.domain.model.PersonalInfo
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

    fun editSkill(index: Int) {

    }

    private fun editWork(
        organisation: String,
        from: String,
        to: String,
        role: String,
        description: String
    ) {
        _state.update { currentState ->
            val updatedWorkExperience = currentState.workExperience.map { work ->
                if (work.organisation == organisation) {
                    // If the organisation matches, update the properties
                    work.copy(from = from, to = to, role = role, description = description)
                } else {
                    // Otherwise, keep the work object unchanged
                    work
                }
            }
            currentState.copy(workExperience = updatedWorkExperience)
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