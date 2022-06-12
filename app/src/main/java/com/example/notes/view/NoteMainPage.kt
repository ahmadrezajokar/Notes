package com.example.notes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.core.adapter.Adapter
import com.example.notes.core.entity.NoteModel
import com.example.notes.core.module.AppModule
import com.example.notes.core.server.NetworkResult
import com.example.notes.databinding.ActivityNoteMainPageBinding
import com.example.notes.core.viewModel.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteMainPage() :
    AppCompatActivity() {


    lateinit var appModule: AppModule
    lateinit var databinding: ActivityNoteMainPageBinding
    val viewModel by viewModels<ViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_note_main_page)
        appModule = AppModule()
        fetchData()
        onClick()

    }


    fun onClick() {
        databinding.imgAdd.setOnClickListener {
            appModule.base().onCLickIntent(this, NoteText::class.java)
        }
    }




    private fun fetchData() {
        viewModel.fetchResponse()
        viewModel.response.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    actionList(response)
                    Toast.makeText(this,response.data.toString().trim(),Toast.LENGTH_SHORT).show()
                }
                is NetworkResult.Error -> {
                    Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
                }
                is NetworkResult.Loading -> {
                    Toast.makeText(this, "Please Wait", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }



    fun actionList(response: NetworkResult<NoteModel>){
        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recycle_view)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<NoteModel>()
        response.data?.let { data.add(it) }

        // This loop will create 20 Views containing
        // the image with the count of view
//        for (i in 1..20) {
//            data.add(NoteModel(R.drawable.ic_baseline_folder_24, "Item " + i))
//        }

        // This will pass the ArrayList to our Adapter
        val adapter = Adapter(viewModel,data,this)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }
}