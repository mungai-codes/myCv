package com.mungai_codes.mycv.presentation.cvscreen

import com.mungai_codes.mycv.presentation.util.Section

sealed interface UiEvent {
    data class ExpandSection(val section: Section) : UiEvent
    object NavigateToEditCvScreen : UiEvent
}