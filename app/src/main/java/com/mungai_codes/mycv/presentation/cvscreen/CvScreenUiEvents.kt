package com.mungai_codes.mycv.presentation.cvscreen

import com.mungai_codes.mycv.presentation.util.Section

sealed interface CvScreenUiEvents {
    data class ExpandSection(val section: Section) : CvScreenUiEvents
    object NavigateToEditCvScreen : CvScreenUiEvents
}