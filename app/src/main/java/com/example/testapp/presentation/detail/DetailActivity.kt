package com.example.testapp.presentation.detail

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.load
import com.example.testapp.R

class DetailActivity : AppCompatActivity() {

    private lateinit var iv_detail: ImageView
    private lateinit var tv_title: TextView
    private lateinit var tv_description: TextView
    private lateinit var btn_back: ImageButton
    private lateinit var btn_share: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val image = intent.getStringExtra("image")
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")

        iv_detail = findViewById<ImageView>(R.id.image_detail)
        tv_title = findViewById<TextView>(R.id.tv_title)
        tv_description = findViewById<TextView>(R.id.tv_description)
        btn_back = findViewById<ImageButton>(R.id.btn_back)
        btn_share = findViewById<ImageButton>(R.id.btn_share)

        iv_detail.load(image)
        tv_title.text = title
        tv_description.text = description

        btn_back.setOnClickListener {
            finish()
        }

        btn_share.setOnClickListener {
            // Handle share button click
            shareContent()
        }
    }
    private fun shareContent(){
        val imageUrl = intent.getStringExtra("image")
        val title = tv_title.text.toString()
        val description = tv_description.text.toString()

        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, title)
            putExtra(Intent.EXTRA_TEXT, "$title\n$description\n$imageUrl")
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
}