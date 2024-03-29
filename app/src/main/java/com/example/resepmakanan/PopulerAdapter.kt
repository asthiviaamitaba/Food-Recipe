package com.example.resepmakanan

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.resepmakanan.databinding.PopulerRvItemBinding

class PopulerAdapter (var dataList:ArrayList<Recipe>, var context: Context):
    RecyclerView.Adapter<PopulerAdapter.ViewHolder>(){

    inner class ViewHolder(var binding: PopulerRvItemBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding=PopulerRvItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        
        Glide.with(context).load(dataList.get(position).img).into(holder.binding.populerImg)
        holder.binding.populerTxt.text=dataList.get(position).tittle
        var time=dataList.get(position).ing.split("\n".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()

        holder.binding.populerTime.text=time.get(0)
        holder.itemView.setOnClickListener{
            var intent=Intent(context,RecipeActivity::class.java)
            intent.putExtra("img",dataList.get(position).img)
            intent.putExtra("tittle",dataList.get(position).tittle)
            intent.putExtra("des",dataList.get(position).des)
            intent.putExtra("ing",dataList.get(position).ing)
            intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(intent)
        }
    }
}