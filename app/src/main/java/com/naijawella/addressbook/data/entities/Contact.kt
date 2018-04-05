package com.naijawella.addressbook.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Contact(
        @PrimaryKey(autoGenerate = true)
        val contactId: Int? = null,
        val firstName: String,
        val lastName: String,
        val email: String,
        val phoneNumber: String
)