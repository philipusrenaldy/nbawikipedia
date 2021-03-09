package com.submission.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter (private val adapterlist: ArrayList<Model>):
    RecyclerView.Adapter<Adapter.Viewholder>(){

    inner class Viewholder(itemview: View): RecyclerView.ViewHolder(itemview) {
        val name = itemView.findViewById(R.id.namatim) as TextView
        val desc = itemView.findViewById(R.id.desc) as TextView
        val teamlogo = itemview.findViewById(R.id.teamlogo) as ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.Viewholder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.content, parent, false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Adapter.Viewholder, position: Int) {
        holder.name.text = adapterlist[position].nama
        holder.desc.text = adapterlist[position].profile
        Glide.with(holder.itemView.context)
                .load(adapterlist[position].image)
                .into(holder.teamlogo)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, Detail::class.java)
            intent.putExtra(Detail.TNAME, adapterlist[position].nama)
            intent.putExtra(Detail.TDESC, adapterlist[position].profile)
            intent.putExtra(Detail.IMAGE, adapterlist[position].image)
            intent.putExtra(Detail.TDETAIL, adapterlist[position].desc)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return adapterlist.size
    }
}