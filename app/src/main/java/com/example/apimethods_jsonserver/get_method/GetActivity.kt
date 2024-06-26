package com.example.apimethods_jsonserver.get_method

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.apimethods_jsonserver.R
import com.example.apimethods_jsonserver.databinding.ActivityGetBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class GetActivity : AppCompatActivity() {

    /* Global Escope Variables */
    private lateinit var viewBinding: ActivityGetBinding
    private lateinit var recyclerViewGet: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewBinding = ActivityGetBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /* Execution of Functions */
        globalLevelSettings()
//        settingRecyclerViewGet()
//        responseControllerGet()
        backToMainActivity()
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

        //recyclerViewGet = viewBinding.recyclerViewGetId
        textViewTitle.text = getString(R.string.get_method)
        textViewSubTitle.text = getString(R.string.api_data)
    }
}