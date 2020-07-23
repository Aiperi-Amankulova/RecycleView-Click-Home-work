package com.example.recycleviewcliclk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val adapter = AdapterMain()

    private var rvMain: RecyclerView?=null
    private var etMain: EditText?=null
    private var btnDelete: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        itemView()
        Adapter()
        Listener()
    }

    private fun itemView() {
        rvMain = findViewById(R.id.rvMain)
        etMain=findViewById(R.id.etMain)
        btnDelete=findViewById(R.id.btnDelete)
    }

    private fun Adapter() {
        rvMain?.adapter = adapter
        adapter.update(getDAta())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {               /// <--для того чтобы menux xml появилось в main activity
        menuInflater.inflate(R.menu.menu_main, menu)
        adapter.add(DataClass(1,"Emodji","About emodji"))
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuMain->adapter.add(DataClass(1,"hello1","hello2"))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun Listener() {
        btnDelete?.setOnClickListener {
            !etMain?.text.isNullOrEmpty()
            adapter.delete(etMain?.text.toString().toInt())
        }
    }

    private fun getDAta(): ArrayList<DataClass>  {
        val list = arrayListOf<DataClass>()
        for (i in 1..500){
            list.add(DataClass(R.drawable.ic_launcher_background,"Go $i","0$i"))
        }
        return list
    }
}