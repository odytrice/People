package com.naijawella.addressbook

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.naijawella.addressbook.data.entities.Contact
import com.naijawella.addressbook.viewmodels.ContactsViewModel
import com.naijawella.addressbook.viewmodels.ViewModelFactory

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val model = ViewModelProviders.of(this, ViewModelFactory(this)).get(ContactsViewModel::class.java)

        model.contacts.observe(this, Observer<List<Contact>>({ contacts ->
            Snackbar.make(fab, "Contacts: ${contacts?.size}", Snackbar.LENGTH_LONG).setAction("Action", null).show()
            Log.d("Tag","Contacts: ${contacts?.size}")}
        ))

        fab.setOnClickListener {
            model.addContact(Contact(null,"John", "Smith", "user@email.com","012345678"))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                Log.d("Hello World","")
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
