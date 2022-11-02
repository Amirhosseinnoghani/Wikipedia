package com.example.wikipedia

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ActivityMain2Binding
import com.example.wikipedia.fragments.SEND_DATA_TO_SECOND_ACTIVITY

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMain2Binding
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarAsli)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.collapsingMain.setExpandedTitleColor(
            ContextCompat.getColor(
                this,
                android.R.color.transparent
            )
        )

        val dataPost = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_SECOND_ACTIVITY)
        if (dataPost != null) {
            showData(dataPost)

        }

    }

    private fun showData(itemPost: ItemPost) {
        Glide.with(this).load(itemPost.imgUrl).into(binding.imgActivity2)
        binding.txtActivity2Title.text = itemPost.txtTitle
        binding.txtActivity2Subtitle.text = itemPost.txtSubtitle
        binding.txtActivity2Text.text = itemPost.txtDetail

        binding.fabMain.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW , Uri.parse("https://en.wikipedia.org/wiki/Main_Page"))
            startActivity(intent)
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return true
    }
}