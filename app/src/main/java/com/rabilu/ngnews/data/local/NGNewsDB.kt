package com.rabilu.ngnews.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rabilu.ngnews.data.model.News

@Database(entities = [News::class], version = 3)
abstract class NGNewsDB : RoomDatabase() {
    abstract fun newsDao(): NewsDao

}