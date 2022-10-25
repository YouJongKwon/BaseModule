package com.base.basemodule.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.base.basemodule.databinding.ItemUserBinding
import com.base.basemodule.recyclerview.datamodel.UserDataModel

class AdapterUser() :
    RecyclerView.Adapter<AdapterUser.ItemViewHolder>() {

    private var list = mutableListOf<UserDataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        return ItemViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // todo UI settings

        val data = list.get(position)
        holder.binding.tvName.text = data.name
        holder.binding.tvTel.text = data.tel
    }

    override fun getItemCount(): Int {
        return list.size;
    }

    fun addItem(item : UserDataModel){
        list.add(item)
        notifyItemInserted(list.size)
    }

    fun addList(list: MutableList<UserDataModel>) {
        list.addAll(list)
        notifyDataSetChanged()
    }

    fun setList(list : MutableList<UserDataModel>){
        this.list = list
        notifyDataSetChanged()
    }

    class ItemViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {}


}