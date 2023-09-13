package com.mungai_codes.mycv.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mungai_codes.mycv.presentation.cvscreen.CvScreenEvents
import com.mungai_codes.mycv.presentation.cvscreen.CvScreenUiEvents
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _state = MutableStateFlow(AppUiState())
    val state = _state.asStateFlow()

    private val _uiEventFlow = MutableSharedFlow<CvScreenUiEvents>()
    val uiEventFlow = _uiEventFlow.asSharedFlow()

    fun onEvent(cvScreenEvent: CvScreenEvents) {
        when (cvScreenEvent) {
            CvScreenEvents.OnEditCvEvent -> {
                viewModelScope.launch {
                    _uiEventFlow.emit(CvScreenUiEvents.NavigateToEditCvScreen)
                }
            }

            is CvScreenEvents.OnSectionClickedEvent -> {
                viewModelScope.launch {
                    _uiEventFlow.emit(CvScreenUiEvents.ExpandSection(cvScreenEvent.section))
                }
            }
        }
    }

    fun updateBioSection() {
        _state.update { it.copy(expandBioSection = !_state.value.expandBioSection) }
    }

    fun updateWorkExperienceSection() {
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