package com.rezaharis.githubuser

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rezaharis.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listUser = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvView()
    }

    private fun rvView(){
        val listUserAdapter = UserAdapter(listUser)
        binding.rvView.adapter = listUserAdapter
        binding.rvView.layoutManager = LinearLayoutManager(this)
        binding.rvView.setHasFixedSize(true)
        listUser.addAll(getUserData())
    }

    @SuppressLint("Recycle")
    private fun getUserData(): ArrayList<User>{
        val username = resources.getStringArray(R.array.username)
        val name = resources.getStringArray(R.array.name)
        val photo = resources.obtainTypedArray(R.array.avatar)
        val location = resources.getStringArray(R.array.location)
        val repository = resources.getStringArray(R.array.repository)
        val company = resources.getStringArray(R.array.company)
        val followers = resources.getStringArray(R.array.followers)
        val following = resources.getStringArray(R.array.following)

        val listUser = ArrayList<User>()
        for (position in name.indices){
            val user = User(
                    username[position],
                    name[position],
                    photo.getResourceId(position, 0),
                    location[position],
                    repository[position],
                    company[position],
                    followers[position],
                    following[position]
            )
            listUser.add(user)
        }
        return listUser
    }
}