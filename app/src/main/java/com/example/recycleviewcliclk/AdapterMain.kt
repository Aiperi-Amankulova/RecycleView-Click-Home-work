package com.example.recycleviewcliclk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_main.view.*

class AdapterMain:RecyclerView.Adapter<AdapterMain.showVh>() {
    private var data = arrayListOf<DataClass>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): showVh {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_main,parent,false)
        return showVh(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: showVh, position: Int) {
        holder.bind(data[position])
    }

    fun update (data:ArrayList<DataClass>){
        this.data=data
        notifyDataSetChanged()
    }

    fun delete(add:Int){
        if (add > -1 && data.size > add){
            data.removeAt(add)
            notifyDataSetChanged()
        }
    }

    fun add(item: DataClass){
        data.add(item)
        notifyItemInserted(+1)

    }


    class showVh(view:View):RecyclerView.ViewHolder(view) {
        fun bind(item: DataClass) {
            itemView.tvInMain.text = item.tvInMain
            itemView.tvInMainAc.text = item.tvInMainAc
            itemView.img.setBackgroundResource(item.img)
        }
    }}
