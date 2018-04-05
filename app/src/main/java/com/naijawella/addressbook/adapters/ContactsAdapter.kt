package com.naijawella.addressbook.adapters

import android.support.v7.util.DiffUtil
import android.support.v7.util.DiffUtil.calculateDiff
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.naijawella.addressbook.data.entities.Contact
import com.naijawella.addressbook.databinding.ListitemContactBinding
import kotlin.properties.Delegates

class ContactsAdapter : RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>(), AutoUpdatableAdapter {

    var contacts: List<Contact> by Delegates.observable(emptyList()) {
        prop, old, new ->
        autoNotify(old, new) { o, n -> o.contactId == n.contactId }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ListitemContactBinding.inflate(inflater, parent, false)

        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.binding.contact = contacts[position]
    }


    class ContactViewHolder(val binding: ListitemContactBinding) : RecyclerView.ViewHolder(binding.root)
}