package com.example.apimethods_jsonserver.post_method.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apimethods_jsonserver.R
import com.example.apimethods_jsonserver.databinding.ActivityPostBinding
import com.example.apimethods_jsonserver.post_method.controller.PostController
import com.example.apimethods_jsonserver.post_method.model.PostModelRequest
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class PostActivity : AppCompatActivity() {

    /* Global Escope Variables */
    private lateinit var viewBinding: ActivityPostBinding
    private lateinit var apiController: PostController


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewBinding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /* Execution of Functions */
        globalLevelSettings()
        backToMainActivity()
        postData()
    }

    private fun postData() {
        val progressBar = findViewById<ProgressBar>(R.id.progressarBar_id)
        val buttonSendData = viewBinding.buttonSendDataPostId

        apiController = PostController()

        buttonSendData.setOnClickListener {
            val name = viewBinding.editTextPostNameId.text.toString()
            val phone = viewBinding.editTextPostPhoneId.text.toString().toLongOrNull() ?: 0L
            val age = viewBinding.editTextPostAgeId.text.toString().toIntOrNull() ?: 0

            val requestData = PostModelRequest(name = name, phone = phone, age = age)

            progressBar.visibility = View.VISIBLE

            apiController.postData(requestData) { response, throwable ->
                progressBar.visibility = View.INVISIBLE
                if (response != null) {
                    val responseData = response.body()
                    Toast.makeText(this, "Dados POST enviados com sucesso", Toast.LENGTH_LONG).show()
                    println("Dados Sucesso POST = $responseData")
                } else {
                    Toast.makeText(this, "A solicitação POST falhou!", Toast.LENGTH_LONG).show()
                    throwable?.printStackTrace()
                    println("Dados Erro POST = $throwable")
                }
            }
        }
    }

    private fun backToMainActivity() {

        val buttomBack = findViewById<MaterialButton>(R.id.button_navigateActivity_id)
        buttomBack.text = getString(R.string.back_main_activity)

        buttomBack.setOnClickListener {

            if (buttomBack.isClickable) {

                finish()
            }
        }
    }

    private fun globalLevelSettings() {

        val textViewTitle = findViewById<MaterialTextView>(R.id.textView_title_id)
        val textViewSubTitle = findViewById<MaterialTextView>(R.id.textView_subtitle_id)

        textViewTitle.text = getString(R.string.post_method)
        textViewSubTitle.text = getString(R.string.api_data)
    }
}