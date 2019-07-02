package com.hardeep.androidkotlindeletion.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor

class DatabaseQueries {

    var sql : DatabaseCreation?= null
    constructor(context: Context)
    {
        sql = DatabaseCreation(context)
    }

    /**
     * addUser Method for user registration
     */
    fun addUser(name:String,email:String,password:String):Long
    {
        val db = sql!!.writableDatabase
        val cv = ContentValues()
        cv.put(DatabaseColumns.USER_NAME,name)
        cv.put(DatabaseColumns.USER_EMAIL,email)
        cv.put(DatabaseColumns.USER_PASS,password)
        return db.insert(DatabaseColumns.TABLE_NAME,null,cv)
    }

    fun loginUser(email: String,password: String):Cursor
    {
        val db = sql!!.readableDatabase
        return db.query(DatabaseColumns.TABLE_NAME,null,DatabaseColumns.USER_EMAIL+"=? AND "+DatabaseColumns.USER_PASS + "=?",
            arrayOf(email,password),null,null,null)
    }

    fun getUsers():Cursor
    {
        val db = sql!!.readableDatabase
        return db.query(DatabaseColumns.TABLE_NAME,null,null,null,null,null,null)
    }

    /*
    * Delete data from the database
     */
    fun deleteUser(email: String):Int
    {
        val db = sql!!.writableDatabase
        return db.delete(DatabaseColumns.TABLE_NAME,DatabaseColumns.USER_EMAIL+"=?", arrayOf(email))
    }

    fun updateUser(name: String, email: String):Int
    {
        val db = sql!!.writableDatabase
        val cv = ContentValues()
        cv.put(DatabaseColumns.USER_NAME,name)

        return db.update(DatabaseColumns.TABLE_NAME,
            cv,
            DatabaseColumns.USER_EMAIL+"=?",
            arrayOf(email))
    }

}