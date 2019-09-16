package com.bittitans.nfchallticket

import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NdefMessage
import android.nfc.NdefRecord
import android.nfc.NfcAdapter
import android.nfc.NfcAdapter.getDefaultAdapter
import android.nfc.Tag
import android.nfc.tech.NfcF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.firebase.ui.auth.AuthUI
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var message:String = "";
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(intent.action == "android.nfc.action.NDEF_DISCOVERED") {
            Toast.makeText(this, "NFC Tag Scanned", Toast.LENGTH_LONG).show()
            intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)?.also { rawMessages ->
                val messages: List<NdefMessage> = rawMessages.map { it as NdefMessage }
                // Process the messages array.
                message = String((messages.get(0).records[0].payload)).drop(3)
            }
            val id = message
            var bundle = bundleOf("id" to id)
            findNavController(R.id.nav_host_fragment).navigate(R.id.action_home3_to_scanFragment, bundle)
        }
        val navController:NavController = Navigation.findNavController(this,R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.logout -> {
                AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener {
                        // ...
                    }
             findNavController(R.id.nav_host_fragment).navigate(R.id.action_home3_to_signoutFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    fun onClick1(v:View)
    {
        var bundle = bundleOf("code" to PassSub.subcode[0],"name" to PassSub.subname[0],"date" to PassSub.subdate[0],"time" to PassSub.subtime[0])
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_scanFragment_to_subjectFragment,bundle)
    }
    fun onClick2(v:View)
    {
        var bundle = bundleOf("code" to PassSub.subcode[1],"name" to PassSub.subname[1],"date" to PassSub.subdate[1],"time" to PassSub.subtime[1])
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_scanFragment_to_subjectFragment,bundle)
    }
    fun onClick3(v:View)
    {
        var bundle = bundleOf("code" to PassSub.subcode[2],"name" to PassSub.subname[2],"date" to PassSub.subdate[2],"time" to PassSub.subtime[2])
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_scanFragment_to_subjectFragment,bundle)
    }
    fun onClick4(v:View)
    {
        var bundle = bundleOf("code" to PassSub.subcode[3],"name" to PassSub.subname[3],"date" to PassSub.subdate[3],"time" to PassSub.subtime[3])
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_scanFragment_to_subjectFragment,bundle)
    }
    fun onClick5(v:View)
    {
        var bundle = bundleOf("code" to PassSub.subcode[4],"name" to PassSub.subname[4],"date" to PassSub.subdate[4],"time" to PassSub.subtime[4])
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_scanFragment_to_subjectFragment,bundle)
    }
    fun onClick6(v:View)
    {
        var bundle = bundleOf("code" to PassSub.subcode[5],"name" to PassSub.subname[5],"date" to PassSub.subdate[5],"time" to PassSub.subtime[5])
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_scanFragment_to_subjectFragment,bundle)
    }
    fun onClick7(v:View)
    {
        var bundle = bundleOf("code" to PassSub.subcode[6],"name" to PassSub.subname[6],"date" to PassSub.subdate[6],"time" to PassSub.subtime[6])
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_scanFragment_to_subjectFragment,bundle)
    }
    fun onClick8(v:View)
    {
        var bundle = bundleOf("code" to PassSub.subcode[7],"name" to PassSub.subname[7],"date" to PassSub.subdate[7],"time" to PassSub.subtime[7])
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_scanFragment_to_subjectFragment,bundle)
    }


}

