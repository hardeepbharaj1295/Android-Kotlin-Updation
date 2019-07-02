package com.hardeep.androidkotlindeletion.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Press alt + enter to implement all the packages
class DatabaseCreation(context: Context?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    val user_table = "CREATE TABLE ${DatabaseColumns.TABLE_NAME} (${DatabaseColumns.USER_NAME} TEXT," +
            "${DatabaseColumns.USER_EMAIL} TEXT, ${DatabaseColumns.USER_PASS} TEXT)"

    val user_drop = "DROP TABLE IF EXISTS ${DatabaseColumns.TABLE_NAME}"

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(user_drop)
        onCreate(db)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(user_table)
    }

    companion object{
        const val DB_NAME = "users.db"
        const val DB_VERSION = 1
    }
}