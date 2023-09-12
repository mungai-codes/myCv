package com.mungai_codes.mycv.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mungai_codes.mycv.domain.model.CvDetails

@Database(entities = [CvDetails::class], version = 1)
abstract class MyCvDatabase : RoomDatabase() {
}