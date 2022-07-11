package com.example.githubuserapp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class UserDetailPage : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Detail Page"

        if (application.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.user_detail_page)
        } else {
            setContentView(R.layout.activity_user_detail_page)
        }

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        val avatar: ImageView = findViewById(R.id.detailPage_avatar)
        val userName: TextView = findViewById(R.id.userName)
        val fullName: TextView = findViewById(R.id.fullName)
        val location: TextView = findViewById(R.id.location)
        val company: TextView = findViewById(R.id.company)
        val follower: TextView = findViewById(R.id.follower)
        val following: TextView = findViewById(R.id.following)
        val repository: TextView = findViewById(R.id.repository)

        avatar.setImageResource(user.avatar)
        userName.text = user.username
        fullName.text = user.name
        location.text = user.location
        company.text = user.company
        follower.text = user.follower
        following.text = user.following
        repository.text = user.repository
    }
}