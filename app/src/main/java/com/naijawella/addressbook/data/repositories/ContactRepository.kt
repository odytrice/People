package com.naijawella.addressbook.data.repositories

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.naijawella.addressbook.data.entities.Contact

@Dao
interface ContactRepository {

    @Query("SELECT * FROM Contact")
    fun getContacts(): LiveData<List<Contact>>

    @Query("SELECT * FROM Contact WHERE contactId = :contactId")
    fun getContactById(contactId: Int): LiveData<Contact?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact: Contact): Long

    @Delete
    fun deleteContact(contact: Contact)
}