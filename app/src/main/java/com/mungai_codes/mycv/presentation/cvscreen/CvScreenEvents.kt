package com.mungai_codes.mycv.presentation.cvscreen

import com.mungai_codes.mycv.presentation.util.Section

sealed interface CvScreenEvents {
    data class OnSectionClickedEvent(val section: Section) : CvScreenEvents
    object OnEditCvEvent : CvScreenEvents
}
