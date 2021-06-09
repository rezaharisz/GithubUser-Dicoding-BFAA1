package com.rezaharis.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.rezaharis.githubuser.databinding.UserDetailsBinding

class UserDetails : AppCompatActivity() {
    private lateinit var binding: UserDetailsBinding

    companion object{
        const val USER = "user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userData()
        btnBack()
    }

    private fun userData(){
        val user = intent.getParcelableExtra<User>(USER) as User
        binding.ivProfile2.setImageResource(user.avatar)
        binding.tvName2.text = user.name
        binding.tvUsername2.text = StringBuilder("@").append(user.username)
        binding.tvFollowing.text = user.following
        binding.tvFollowers.text = user.followers
        binding.tvRepository.text = user.repository
        binding.tvLocation.text = user.location
        binding.tvCompany.text = user.company
    }

    private fun btnBack(){
        val btnBack = findViewById<ImageView>(R.id.btn_back)
        btnBack.setOnClickListener {
            super.onBackPressed()
        }
    }
}