package com.example.ninepatchdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MsgAdapter(private var msgList: List<Msg>) : RecyclerView.Adapter<MsgViewHolder>() {
//    inner class LeftViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val leftMsg: TextView = view.findViewById(R.id.leftMsg)
//        val leftImg: ImageView = view.findViewById(R.id.leftImage)
//    }
//
//    inner class RightViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val rightMsg: TextView = view.findViewById(R.id.rightMsg)
//        val rightlmg: ImageView = view.findViewById(R.id.rightImage)
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        val msg = msgList[position]
//        return msg.type
//    }

    //在该方法中返回当前消息所对应的消息类型
    override fun getItemViewType(position: Int) = msgList[position].type

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == Msg.TYPE_RECEIVED) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item, parent, false)
            LeftViewHolder(view)
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item, parent, false)
            val rightViewHolder = RightViewHolder(view)
            //设置长按事件监听器
            RightViewHolder(view).itemView.setOnLongClickListener {
                msgList -= msgList[rightViewHolder.adapterPosition]
                notifyItemRemoved(rightViewHolder.adapterPosition)
                true
            }
            rightViewHolder
        }

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg = msgList[position]
        when (holder) {
            is LeftViewHolder -> {
                holder.leftImg.setImageResource(msg.MsgiMGEid)
                holder.leftMsg.text = msg.context
            }
            is RightViewHolder -> {
                holder.rightlmg.setImageResource(msg.MsgiMGEid)
                holder.rightMsg.text = msg.context
            }
        }
    }

    override fun getItemCount() = msgList.size

    fun getList() = msgList
}