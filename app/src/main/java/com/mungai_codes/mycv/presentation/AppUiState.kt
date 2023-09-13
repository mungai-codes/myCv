package com.mungai_codes.mycv.presentation

import com.mungai_codes.mycv.R
import com.mungai_codes.mycv.domain.model.Education
import com.mungai_codes.mycv.domain.model.PersonalInfo
import com.mungai_codes.mycv.domain.model.Skill
import com.mungai_codes.mycv.domain.model.Social
import com.mungai_codes.mycv.domain.model.Work

data class AppUiState(
    val expandBioSection: Boolean = true,
    val expandWorkExperienceSection: Boolean = false,
    val expandEducationSection: Boolean = false,
    val expandSkillsSection: Boolean = true,
    val expandSocialsSection: Boolean = true,
    val personalInfo: PersonalInfo = PersonalInfo(
        fullName = "Moses Mungai Kabea",
        bio = "A dedicated and highly skilled Android Developer experienced in designing, developing, and maintaining cutting-edge Android applications. Adept at collaborating with cross-functional teams to deliver high-quality, user-friendly mobile solutions. Proficient in Java, Kotlin, and the latest Android technologies, with a passion for staying updated on industry trends."
    ),
    val workExperience: List<Work> = listOf(
        Work(
            from = "sept 2022",
            to = "dec 2022",
            organisation = "Mt Kenya University",
            role = "IT technician",
            description = "Ensuring the organization's technology operates seamlessly. Handling everything from configuring hardware and software to troubleshooting and resolving technical challenges that arise. Daily tasks involved assisting and educating users on technology issues, safeguarding our network's security, and implementing data backup and recovery measures."
        )
    ),
    val education: List<Education> = listOf(
        Education(
            from = "2013",
            to = "2017",
            institution = "Kahuho Uhuru High School",
            qualification = "KCPE",
            grade = "B+"
        ),
        Education(
            from = "2018",
            to = "2022",
            institution = "Chuka University",
            qualification = "Bsc Applied Computer Science",
            grade = "Second Upper Class"
        ),
    ),
    val skills: List<Skill> = listOf(
        Skill(skill = "Android App Development", description = "kotlin/java"),
        Skill(skill = "Version Control ", description = "Git"),
        Skill(skill = "Problem Solving"),
        Skill(skill = "Clean Architecture", description = "MVVM")
    ),
    val socials: List<Social> = listOf(
        Social(name = "Slack", icon = R.drawable.ic_slack, handle = "Moses Mungai"),
        Social(name = "Github", icon = R.drawable.ic_github, handle = "mungai-codes")
    )
)
