package com.naijawella.addressbook.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.os.AsyncTask
import com.naijawella.addressbook.data.entities.Contact
import com.naijawella.addressbook.data.managers.ContactManager

class ContactsViewModel(private val _contactMgr: ContactManager) : ViewModel(){

    val contacts: LiveData<List<Contact>> = _contactMgr.getContacts()

    fun addContact(contact: Contact){
        AddContactAsyncTask(_contactMgr).execute(contact)
    }

    class AddContactAsyncTask(private val _contactMgr: ContactManager): AsyncTask<Contact, Unit, Unit>(){
        override fun doInBackground(vararg params: Contact?) {
            val contact = params[0]
            if(contact != null) {
                _contactMgr.addContact(contact)
            }
        }
    }
}