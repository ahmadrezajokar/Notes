package com.example.notes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.notes.R
import com.example.notes.core.module.AppModule
import com.example.notes.core.server.NetworkResult
import com.example.notes.core.viewModel.ViewModel
import com.example.notes.databinding.ActivityNoteTextBinding
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteEdit : AppCompatActivity() {


    lateinit var databinding: ActivityNoteTextBinding
    val viewModel by viewModels<ViewModel>()
    lateinit var appModule: AppModule
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_note_edit)
        appModule = AppModule()
     //   fetchData()
    }




    private fun fetchData() {
        viewModel.fetchResponse()
        viewModel.response.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {
//                    appModule.provideConverterFactory()

                    //     appModule.provideCurrencyService()
                }
                is NetworkResult.Error -> {
                    Toast.makeText(this, "Error Server", Toast.LENGTH_SHORT).show()
                }
                is NetworkResult.Loading -> {
                    Toast.makeText(this, "Please Wait", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}