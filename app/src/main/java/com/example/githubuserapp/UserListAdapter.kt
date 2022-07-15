package com.example.githubuserapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubuserapp.databinding.ItemRowUserBinding

class UserListAdapter(private val listUser: ArrayList<User>): RecyclerView.Adapter<UserListAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback


    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (_, name, avatar) = listUser[position]
        holder.itemViewBinding.userName.text = name
        Glide.with(holder.itemView.context)
            .load(avatar)
            .circleCrop()
            .into(holder.itemViewBinding.avatar)

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listUser[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listUser.size


    class ListViewHolder(var itemViewBinding: ItemRowUserBinding) : RecyclerView.ViewHolder(itemViewBinding.root)

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}