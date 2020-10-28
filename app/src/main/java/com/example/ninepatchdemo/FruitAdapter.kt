package com.example.listviewdemo2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.ninepatchdemo.Fruit
import com.example.ninepatchdemo.R
import java.text.SimpleDateFormat
import java.util.*

class FruitAdapter(context: Context, private val resource: Int, data: List<Fruit>) :
    ArrayAdapter<Fruit>(context, resource, data) {
    inner class ViewHolder(
        val fruitImage: ImageView,
        val fruitName: TextView,
        val fruitTiding: TextView,
        val fruitTime: TextView
    )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder: ViewHolder
        val view: View
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resource, parent, false)
            val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
            val fruitName: TextView = view.findViewById(R.id.fruitName)
            val fruitTiding :TextView = view.findViewById(R.id.fruitTiding)
            val fruitTime: TextView = view.findViewById(R.id.fruitTime)
            viewHolder = ViewHolder(fruitImage, fruitName,fruitTiding,fruitTime)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        val fruit = getItem(position)
        if (fruit != null) {
            viewHolder.fruitImage.setImageResource(fruit.imageId)
            viewHolder.fruitName.text = fruit.name
            viewHolder.fruitTiding.text = fruit.news
            viewHolder.fruitTime.text = getTime()
        }
        return view
    }
    //时间
    private fun getTime(): String {
        val data = Date()
        val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.CHINA)
        return dateFormat.format(data)
    }

}
