package com.hllbr.sqliteprojectupdateanddeletecommandkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try{
            val myDatabse = this.openOrCreateDatabase("Musicians", MODE_PRIVATE,null)
            myDatabse.execSQL("CREATE TABLE IF NOT EXISTS musicians (id INTEGER PRIMARY KEY,name VARCHAR,age INT)")
            //myDatabse.execSQL("INSERT INTO musicians (name,age) VALUES ('LARS',85)")
          //myDatabse.execSQL("UPDATE musicians SET age = 62 WHERE name = 'Kirk'")//Güncelle(update) neyi yaşı(set)
            //myDatabse.execSQL("UPDATE musicians SET name ='JAMES HAMMET' WHERE name = 'James'")
            //myDatabse.execSQL("UPDATE musicians SET name = 'Kirk HAMMA' WHERE id =1 ")
            //DELETE COMMOAND =

            myDatabse.execSQL("DELETE FROM musicians WHERE name ='LARS'")
            val myCursor = myDatabse.rawQuery("SELECT * FROM musicians",null)
            val nameIx = myCursor.getColumnIndex("name")
            val ageIx = myCursor.getColumnIndex("age")
            val ıdIx = myCursor.getColumnIndex("id")

            while (myCursor.moveToNext()){
                println("name : "+myCursor.getString(nameIx))
                println("age : "+myCursor.getInt(ageIx))
                println("id : "+myCursor.getInt(ıdIx))
            }
            myCursor.close()
        }catch (e : Exception){
            e.printStackTrace()
        }

    }
}