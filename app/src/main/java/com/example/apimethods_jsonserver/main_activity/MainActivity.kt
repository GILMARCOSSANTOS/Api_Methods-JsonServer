package com.example.apimethods_jsonserver.main_activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apimethods_jsonserver.post_method.PostActivity
import com.example.apimethods_jsonserver.R
import com.example.apimethods_jsonserver.databinding.ActivityMainBinding
import com.example.apimethods_jsonserver.get_method.view.GetActivity
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {

    /* Global Escope Variables */
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /* Execute the Functions */
        globalLevelSettings()
        followButton()
    }

    private fun followButton() {

        val buttonGetActivity = viewBinding.buttonGetActivityId
        val buttonPostActivity = viewBinding.buttonPostActivityId

        buttonGetActivity.setOnClickListener {

            if (buttonGetActivity.isClickable) {

                val intent = Intent(this, GetActivity::class.java).apply {
                }

                startActivity(intent)
            }
        }

        buttonPostActivity.setOnClickListener {

            if (buttonPostActivity.isClickable) {

                val intent = Intent(this, PostActivity::class.java).apply {
                }

                startActivity(intent)
            }
        }
    }

    private fun globalLevelSettings() {

        val textViewSubTitle = findViewById<MaterialTextView>(R.id.textView_subtitle_id)
        val textViewTitle = findViewById<MaterialTextView>(R.id.textView_title_id)

        textViewTitle.text = getString(R.string.initial_screen)
        textViewSubTitle.text = getString(R.string.subtitle_main)
    }
}