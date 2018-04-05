package com.naijawella.addressbook.data

import android.arch.persistence.room.*
import android.content.Context
import com.naijawella.addressbook.data.entities.Contact
import com.naijawella.addressbook.data.repositories.ContactRepository


@Database(entities = [Contact::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contact(): ContactRepository

    companion object {
        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "Contacts.db")
                    .build()
        }
    }
}