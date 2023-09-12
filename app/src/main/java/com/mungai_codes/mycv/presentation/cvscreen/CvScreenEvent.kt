package com.mungai_codes.mycv.presentation.cvscreen

import com.mungai_codes.mycv.presentation.util.Section

sealed interface CvScreenEvent {
    data class OnSectionClickedEvent(val section: Section) : CvScreenEvent
    object OnEditCvEvent : CvScreenEvent
}
