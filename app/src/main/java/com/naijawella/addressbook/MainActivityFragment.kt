package com.naijawella.addressbook

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naijawella.addressbook.adapters.ContactsAdapter
import com.naijawella.addressbook.viewmodels.ContactsViewModel
import com.naijawella.addressbook.viewmodels.ViewModelFactory

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val rvContacts = view.findViewById<RecyclerView>(R.id.rvContacts)

        val context = activity ?: throw Exception("This Fragment is not attached to an Activity")
        val model = ViewModelProviders.of(context, ViewModelFactory(context)).get(ContactsViewModel::class.java)

        val contactsAdapter = ContactsAdapter()

        model.contacts.observe(this, Observer {
            contactsAdapter.contacts = it ?: arrayListOf()
        })
        rvContacts.adapter = contactsAdapter
        rvContacts.layoutManager = LinearLayoutManager(context)

        return view
    }
}




