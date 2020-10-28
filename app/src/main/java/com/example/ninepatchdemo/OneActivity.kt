package com.example.listviewdemo2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ninepatchdemo.Fruit
import com.example.ninepatchdemo.MainActivity
import com.example.ninepatchdemo.R
import kotlinx.android.synthetic.main.activity_one.*
import java.util.*


class OneActivity : AppCompatActivity() {
    //private val data = listOf("苹果", "香蕉", "哈密瓜", "月饼", "荔枝", "桂圆", "毛桃", "腊肠", "肠粉", "芒果", "西瓜")
    private val fruitList = ArrayList<Fruit>()


    fun initFruits() {
        repeat(3) {
            fruitList.add(Fruit("19移动总群", "[动态表情]", R.drawable.touxiang))
            fruitList.add(Fruit("19移动总群", "[动态表情]", R.drawable.touxiang))
            fruitList.add(Fruit("19移动总群", "[动态表情]", R.drawable.touxiang))
            fruitList.add(Fruit("19移动总群", "[动态表情]", R.drawable.touxiang))
            fruitList.add(Fruit("19移动总群", "[动态表情]", R.drawable.touxiang))
            fruitList.add(Fruit("19移动总群", "[动态表情]", R.drawable.touxiang))
            fruitList.add(Fruit("19移动总群", "[动态表情]", R.drawable.touxiang))
            fruitList.add(Fruit("19移动总群", "[动态表情]", R.drawable.touxiang))
            fruitList.add(Fruit("19移动总群", "[动态表情]", R.drawable.touxiang))
            fruitList.add(Fruit("19移动总群", "[动态表情]", R.drawable.touxiang))
            fruitList.add(Fruit("19移动总群", "[动态表情]", R.drawable.touxiang))
            fruitList.add(Fruit("19移动总群", "[动态表情]", R.drawable.touxiang))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)

        initFruits()
        //上下文，列表子视图，数据源
        //val adapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, data)
        val fruitAdapter = FruitAdapter(this, R.layout.fruit_item, fruitList)

        //绑定到控件
        //listViewTest.adapter = adapter;
        listViewTest.adapter = fruitAdapter;


        listViewTest.setOnItemClickListener { _, _, i, _ ->
            val fruit = fruitList[i]
//            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()

            //跳转至聊天界面
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

    }
}