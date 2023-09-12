package com.mungai_codes.mycv.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cv_details")
data class CvDetails(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val fullName: String,
    val bio: String,
    val slackUsername: String,
    val githubHandle: String
)
