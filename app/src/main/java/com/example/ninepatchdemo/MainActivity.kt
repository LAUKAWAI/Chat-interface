package com.example.ninepatchdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.chat_bottom.*

class MainActivity : AppCompatActivity() {

    private var msgList = ArrayList<Msg>()
    //private lateinit var adapter: MsgAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMsgData()
        val layoutAdapter = LinearLayoutManager(this)
        RecyclerView.layoutManager = layoutAdapter
        val adapter1 = MsgAdapter(msgList)
        val adapter2 = AlphaInAnimationAdapter(adapter1).apply {
            //设置动画时长
            setDuration(500)
        }
        //叠加上面的动画
        val adapter3 = ScaleInAnimationAdapter(adapter2).apply {
            setDuration(500)
        }
        RecyclerView.adapter = adapter3

        msgsend.setOnClickListener {
            val text = msgText.text.toString()
            if (text.isNotEmpty()) {
                val list = adapter1.getList()
                if (msgList.size != list.size) msgList = list as ArrayList<Msg>

                if (text.isNotEmpty()) {
                    //增加数据到数据源
                    msgList.add(Msg(R.drawable.img_5, text, 1))
                    //通知适配器增加了数据
                    adapter3.notifyItemRangeInserted(msgList.size - 1, 1)
                    //滚动到最新数据的位置上
                    RecyclerView.scrollToPosition(msgList.size - 1)
                    //清空输入框中的内容
                    msgText.setText("")
                }
            }
        }

        rootLayout.addOnLayoutChangeListener { _, _, _, _, bottom, _, _, _, oldBottom ->
            if (oldBottom != -1 && oldBottom > bottom) {
                RecyclerView.requestLayout()
                RecyclerView.post { RecyclerView.scrollToPosition(msgList.size - 1) }
            }

        }

    }

    private fun initMsgData() {
        repeat(2) {
            msgList.add(
                Msg(
                    R.drawable.img_1,
                    "两个include的高度拉不动",
                    0
                )
            )
            msgList.add(
                Msg(
                    R.drawable.img_1,
                    "一直是占满界面",
                    0
                )
            )
            msgList.add(
                Msg(
                    R.drawable.img_5,
                    "直接在界面用控件试试",
                    1
                )
            )
            msgList.add(
                Msg(
                    R.drawable.img_1,
                    "可以拖了",
                    0
                )
            )
            msgList.add(
                Msg(
                    R.drawable.img_4,
                    "啥也没搞，突然又能拖动了。。",
                    0
                )
            )
            msgList.add(
                Msg(
                    R.drawable.img_7,
                    "让人怪不好意思的",
                    0
                )
            )
            msgList.add(
                Msg(
                    R.drawable.img_6,
                    "为啥一点打字会吃掉一点",
                    0
                )
            )
            msgList.add(
                Msg(
                    R.drawable.img_5,
                    "测试看看 下面的区域如果是一个整体，设置一点的Top内边距",
                    1
                )
            )
        }
    }

}