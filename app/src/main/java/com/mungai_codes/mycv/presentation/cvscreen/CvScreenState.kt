package com.mungai_codes.mycv.presentation.cvscreen

import com.mungai_codes.mycv.domain.model.CvDetails

data class CvScreenState(
    val details: CvDetails? = null,
    val expandBioSection: Boolean = true,
    val expandWorkExperienceSection: Boolean = false,
    val expandEducationSection: Boolean = false,
    val expandSkillsSection: Boolean = true,
    val expandSocialsSection: Boolean = true,
)
