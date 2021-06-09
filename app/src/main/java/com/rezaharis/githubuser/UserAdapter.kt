package com.rezaharis.githubuser

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rezaharis.githubuser.databinding.ListUserBinding
import com.bumptech.glide.Glide

class UserAdapter(private val listUser:ArrayList<User>) : RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        private val binding = ListUserBinding.bind(itemView)

        fun bind(user: User){
            Glide.with(itemView.context)
                    .load(user.avatar)
                    .into(binding.ivProfile)
            binding.tvUsername.text = StringBuilder("@").append(user.username)
            binding.tvName.text = user.name
            binding.btnInformation.setOnClickListener {
                val intent = Intent(itemView.context, UserDetails::class.java)
                intent.putExtra(UserDetails.USER, user)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ListViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.list_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.ListViewHolder, position: Int) {
        holder.bind(listUser[position])

    }

    override fun getItemCount(): Int {
        return listUser.size
    }
}