package com.example.githubuserapp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubuserapp.databinding.ActivityUserDetailPageBinding
import com.example.githubuserapp.databinding.UserDetailPageBinding

class UserDetailPage : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailPageBinding
    private lateinit var bindingLand: UserDetailPageBinding

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Detail Page"
        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        if (application.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding = ActivityUserDetailPageBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.run {
                userName.text = user.username
                detailPageAvatar.setImageResource(user.avatar)
                fullName.text = user.name
                location.text = user.location
                company.text = user.company
                follower.text = user.follower
                following.text = user.following
                repository.text = user.repository
            }
        } else {
            bindingLand = UserDetailPageBinding.inflate(layoutInflater)
            setContentView(bindingLand.root)
            bindingLand.run {
                userName.text = user.username
                detailPageAvatar.setImageResource(user.avatar)
                fullName.text = user.name
                location.text = user.location
                company.text = user.company
                follower.text = user.follower
                following.text = user.following
                repository.text = user.repository
            }
        }

    }
}