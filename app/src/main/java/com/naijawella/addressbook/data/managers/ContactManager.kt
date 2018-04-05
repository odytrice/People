package com.naijawella.addressbook.data.managers


import android.arch.lifecycle.LiveData
import com.naijawella.addressbook.data.entities.Contact
import com.naijawella.addressbook.data.repositories.ContactRepository

class ContactManager(private val _repo: ContactRepository) {

    fun getContacts(): LiveData<List<Contact>> {
        return _repo.getContacts()
    }

    fun addContact(contact: Contact){
        _repo.insertContact(contact)
    }

    fun getContactById(contactId: Int): LiveData<Contact?> {
        return _repo.getContactById(contactId)
    }

    fun deleteContact(contact: Contact) {
        _repo.deleteContact(contact)
    }
}