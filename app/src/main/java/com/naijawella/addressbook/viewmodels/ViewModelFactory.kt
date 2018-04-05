package com.naijawella.addressbook.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.naijawella.addressbook.data.AppDatabase
import com.naijawella.addressbook.data.managers.ContactManager

class ViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val database = AppDatabase.getInstance(context)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        fun <T> isOf(theClass: Class<T>): Boolean {
            return modelClass.isAssignableFrom(theClass)
        }

        return when {
            isOf(ContactsViewModel::class.java) -> ContactsViewModel(ContactManager(database.contact())) as T
            else -> throw IllegalArgumentException("Invalid model type")
        }
    }
}