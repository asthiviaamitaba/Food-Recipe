package com.example.resepmakanan

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DatabaseHelper(var context: Context): SQLiteOpenHelper(
    context,DATABASE_NAME,null,DATABASE_VERSION) {

    companion object {
        private val DATABASE_NAME = "resep"
        private val DATABASE_VERSION = 5

        //table account
        private val TABLE_ACCOUNT = "account"

        //column account table
        private val COLUMN_EMAIL = "email"
        private val COLUMN_NAME = "name"
        private val COLUMN_LEVEL = "level"
        private val COLUMN_PASSWORD = "password"
    }

        fun addAccount(email:String, name:String, level:String, password:String){
        val db = this.writableDatabase

        //cek data apakah email telah terdaftar
        val data = checkData(email)
        Toast.makeText(context, data, Toast.LENGTH_SHORT).show()

        if(data != ""){
            Toast.makeText(context, "Your email is already registered", Toast.LENGTH_SHORT).show()
        }else{
            val values = ContentValues()
            values.put(COLUMN_EMAIL, email)
            values.put(COLUMN_NAME, name)
            values.put(COLUMN_LEVEL, level)
            values.put(COLUMN_PASSWORD, password)

            val result = db.insert(TABLE_ACCOUNT,null, values)
            //show message
            if (result==(0).toLong()){
                Toast.makeText(context, "Register Failed", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(context, "Register Success, " +
                        "please login using your new account", Toast.LENGTH_SHORT).show()
            }
        }
        db.close()
    }

    @SuppressLint("Range")
    fun checkData(email:String):String{
        val colums = arrayOf(COLUMN_NAME)
        val db = this.readableDatabase
        val selection = "$COLUMN_EMAIL = ?"
        val selectionArgs = arrayOf(email)
        var name:String = ""

        val cursor = db.query(TABLE_ACCOUNT, //table to query
            colums, //columns to return
            selection, //columns for WHERE clause
            selectionArgs, //the values for the WHERE clause
            null, //group the rows
            null, //filter by row groups
            null) //the sort order
        if(cursor.moveToFirst()){
            name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
        }

        cursor.close()
        return name
    }

    //login check
    @SuppressLint("Range")
    fun checkLogin(email:String, password:String):Boolean{
        val colums = arrayOf(COLUMN_EMAIL, COLUMN_NAME, COLUMN_LEVEL, COLUMN_PASSWORD)
        val db = this.readableDatabase
        //selection criteria
        val selection = "$COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?"
        //selection arguments
        val selectionArgs = arrayOf(email,password)

        val cursor = db.query(TABLE_ACCOUNT, //table to query
            colums, //columns to return
            selection, //columns for WHERE clause
            selectionArgs, //the values for the WHERE clause
            null, //group the rows
            null, //filter by row groups
            null) //the sort order

        val cursorCount = cursor.count



        cursor.close()
        db.close()

        return TODO("Provide the return value")
    }

    override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}
