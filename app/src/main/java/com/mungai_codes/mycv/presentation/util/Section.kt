package com.mungai_codes.mycv.presentation.util

sealed interface Section {
    object BioSection : Section
    object WorkExperienceSection : Section
    object EducationSection : Section
    object SkillsSection : Section
    object SocialsSection : Section
}
