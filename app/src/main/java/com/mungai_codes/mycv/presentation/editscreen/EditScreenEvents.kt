package com.mungai_codes.mycv.presentation.editscreen

import com.mungai_codes.mycv.domain.model.Education
import com.mungai_codes.mycv.domain.model.Skill
import com.mungai_codes.mycv.domain.model.Social
import com.mungai_codes.mycv.domain.model.WorkExperience


sealed interface EditScreenEvents {
    object OnDoneEditingEvent : EditScreenEvents
    data class EditBioEvent(val text: String) : EditScreenEvents
    data class EditSkillsEvent(val skillName: String, val skill: Skill) : EditScreenEvents
    data class EditEducationEvent(val institution: String, val education: Education) : EditScreenEvents
    data class EditWorkExperienceEvent(val organisation: String, val workExperience: WorkExperience) : EditScreenEvents
    data class EditSocialEvent(val name: String, val social: Social) : EditScreenEvents
}