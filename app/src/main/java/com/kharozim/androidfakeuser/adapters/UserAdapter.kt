package com.kharozim.androidfakeuser.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kharozim.androidfakeuser.databinding.ItemUsersBinding
import com.kharozim.androidfakeuser.models.DataItem
import com.kharozim.androidfakeuser.models.UserModel

class UserAdapter(
    private val context: Context, private val listener:UserListener
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    interface UserListener {
        fun onSelect(id: Int)
        fun onDelete(id: Int)
    }

    inner class ViewHolder(
        private val binding: ItemUsersBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun binData(dataItem: DataItem) {
            binding.run {
                tvName.text = dataItem.firstName + " " + dataItem.lastName
                tvEmail.text = dataItem.email
                Glide.with(binding.root).load(dataItem.avatar).circleCrop().into(ivImage)
//                root.setOnClickListener { listener.onSelect(dataItem.id) }
                btDel.setOnClickListener { listener.onDelete(dataItem.id) }
            }
        }
    }


    var list = listOf<DataItem>()
    fun setData(data: List<DataItem>) {
        list = data
        notifyDataSetChanged()
    }

    fun deleteUserById(id: Int) {
        val index = list.indexOfFirst { it.id == id }

        if (index != -1) {
            notifyItemRemoved(index)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemUsersBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}