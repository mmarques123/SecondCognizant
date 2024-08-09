package com.example.secondcognizant

//data/data/com.example.secondcognizant/sharedprefs/filenamecognizant.xml

import android.database.Cursor
import android.os.Bundle
import android.provider.CallLog
import androidx.appcompat.app.AppCompatActivity
import androidx.cursoradapter.widget.SimpleCursorAdapter
import com.example.secondcognizant.database.Item
import com.example.secondcognizant.database.ItemDao
import com.example.secondcognizant.database.ItemRoomDatabase
import com.example.secondcognizant.databinding.ActivityStorageBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


private  val fileName = "filenamecognizant"

private const val NAME = "name"

private const val PWD = "pwd"

class StorageActivity : AppCompatActivity() {

    lateinit var dao: ItemDao


    lateinit var  binding: ActivityStorageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var database = ItemRoomDatabase.getDatabase(this)
        dao = database.itemDao()
        binding = ActivityStorageBinding.inflate(layoutInflater)
       var view = binding.root
        setContentView(view)

    }

    override fun onStart() {
        super.onStart()
        binding.button.setOnClickListener {

            GlobalScope.launch {
                var item = Item(21, "fruits", 11.11, 11)
                dao.insert(item)
            }

        }

        binding.btnGet.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                var item = dao.getItem(21).first()
                binding.tvDb.setText(item.toString())
            }
        }
    }



    override fun onPause() {
        super.onPause()
        storeData()
    }

    private fun storeData() {
        //create a file
        val preferennces = getSharedPreferences(fileName, MODE_PRIVATE)
        //open the file
        val editor = preferennces.edit()
        //write to the file
        editor.putString(NAME,binding.etName.text.toString())
        editor.putString(PWD,binding.etPassword.text.toString())
        //save the file
        editor.apply()
    }

    override fun onResume() {
        super.onResume()
        restoreData()
        val cursor: Cursor? = getContentResolver().query(
            CallLog.Calls.CONTENT_URI,
            null, null, null, CallLog.Calls.DATE + " DESC"
        )
       // val uriSms = Uri.parse("content://sms/inbox")
        //val dataCursor: Cursor? = getContentResolver().query(uriSms, null, null, null, null)
        val colName = CallLog.Calls.NUMBER

        val fromColNames = arrayOf(colName)
        val toTexviewIds = intArrayOf(android.R.id.text1)

        var cursorAdaper = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_1,
            cursor,fromColNames,toTexviewIds)
        binding.listView.adapter = cursorAdaper
    }

    private fun restoreData() {
        //if file exists it'll open that file or create it
        val preferennces = getSharedPreferences(fileName, MODE_PRIVATE)
        val name = preferennces.getString(NAME,"")
        val password = preferennces.getString(PWD,"")
        binding.etName.setText(name)
        binding.etPassword.setText(password)

    }

}