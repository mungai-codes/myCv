package com.mungai_codes.mycv.presentation.cvscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CvScreenViewModel : ViewModel() {

    private val _state = MutableStateFlow(CvScreenState())
    val state = _state.asStateFlow()

    private val _uiEventFlow = MutableSharedFlow<UiEvent>()
    val uiEventFlow = _uiEventFlow.asSharedFlow()

    fun onEvent(cvScreenEvent: CvScreenEvent) {
        when (cvScreenEvent) {
            CvScreenEvent.OnEditCvEvent -> {

            }

            is CvScreenEvent.OnSectionClickedEvent -> {
                viewModelScope.launch {
                    _uiEventFlow.emit(UiEvent.ExpandSection(cvScreenEvent.section))
                }
            }
        }
    }

    fun updateBioSection() {
        _state.update { it.copy(expandBioSection = !_state.value.expandBioSection) }
    }

    fun updateWorkExperienceoSection() {
        _state.update { it.copy(expandWorkExperienceSection = !_state.value.expandWorkExperienceSection) }
    }

    fun updateEducationSection() {
        _state.update { it.copy(expandEducationSection = !_state.value.expandEducationSection) }
    }

    fun updateSkillsSection() {
        _state.update { it.copy(expandSkillsSection = !_state.value.expandSkillsSection) }
    }

    fun updateSocialsSection() {
        _state.update { it.copy(expandSocialsSection = !_state.value.expandSocialsSection) }
    }
}