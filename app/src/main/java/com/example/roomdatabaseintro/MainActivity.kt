package com.example.roomdatabaseintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.view.View
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var database: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Room.databaseBuilder(applicationContext,ContactDatabase::class.java,"contactDb").build()


        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0,"John","64634613"))
        }

    }

    fun getData(view: View) {
        database.contactDao().getContact().observe(this
        ,{
            Log.d("CheezyCode",it.toString())
            })

    }
}