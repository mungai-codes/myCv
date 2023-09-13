package com.mungai_codes.mycv.presentation.editscreen

import com.mungai_codes.mycv.domain.model.Work


sealed interface EditScreenEvents {
    object OnDoneEditingEvent : EditScreenEvents
    data class EditBioEvent(val text: String) : EditScreenEvents

    data class EditSkillsEvent(val index: Int) : EditScreenEvents

}