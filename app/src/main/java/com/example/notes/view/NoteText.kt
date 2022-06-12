package com.example.notes.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.notes.R
import com.example.notes.core.entity.NoteModel
import com.example.notes.core.module.AppModule
import com.example.notes.core.server.NetworkResult
import com.example.notes.core.viewModel.ViewModel
import com.example.notes.databinding.ActivityNoteTextBinding
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NoteText : AppCompatActivity() {



    lateinit var databinding: ActivityNoteTextBinding
    val viewModel by viewModels<ViewModel>()
    lateinit var appModule: AppModule
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_note_text)
        appModule = AppModule()
        onClick()
    }


    fun onClick() {
        databinding.cardSave.setOnClickListener {
            fetchData()
        }
    }


    private fun fetchData() {
        viewModel.fetchResponse()
        viewModel.response.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {
                  // appModule.provideConverterFactory()
//                    var gson:Gson = Gson()
//                    gson.fromJson("title",databinding.flTitle.javaClass)
//                    appModule.provideRetrofit()
                    val notemodel = NoteModel(databinding.flTitle.text.toString().trim(), databinding.editText.text.toString().trim())
                    val json = Gson().toJson(notemodel)
//                    appModule.provideRetrofit(json)

//                    val gson: Gson = GsonBuilder()
//                        .registerTypeAdapter(Id::class.java, IdTypeAdapter())
//                        .enableComplexMapKeySerialization()
//                        .serializeNulls()
//                        .setDateFormat(DateFormat.LONG)
//                        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
//                        .setPrettyPrinting()
//                        .setVersion(1.0)
//                        .create()
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



