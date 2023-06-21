package com.example.foodmenuadviser

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import java.util.Arrays
import java.util.Random

class MainActivity : AppCompatActivity() {

    lateinit var array : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)

        spinner.adapter = ArrayAdapter.createFromResource(this, R.array.array, android.R.layout.simple_spinner_item)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                array = when(position) {
                    0-> arrayOf("비빔면", "불고기", "갈비찜", "삼겹살", "김치찌개", "된장찌개", "해물파전", "김치전", "김밥", "냉면", "라면", "순두부찌개", "콩나물국밥", "소머리국밥", "돼지국밥", "순대국밥", "감자탕", "잡채", "전복죽", "곱창", "물냉면", "보쌈", "족발")
                    1-> arrayOf("짜장면", "고추잡채","딤섬", "마라탕", "꿔바로우", "양장피", "짬뽕", "토마토계란볶음밥", "마파두부덮밥", "깐풍기", "깐쇼새우")
                    2-> arrayOf("초밥", "덴푸라", "소바", "라멘", "텐동", "우동", "규동", "돈카츠", "샤브샤브")
                    3-> arrayOf("파스타", "스테이크", "빵", "피자")
                    4-> arrayOf("BBQ", "BHC", "교촌치킨", "KFC", "네네치킨", "굽네치킨", "호식이두마리치킨", "지코바치킨", "후라이드참잘하는집", "쌀통닭", "자담치킨", "노랑통닭", "치킨플러스")
                    5-> arrayOf("버거킹", "롯데리아", "맥도널드", "프랑크버거", "KFC", "맘스터치", "수제버거")
                    else-> arrayOf("비빔밥", "제육덮밥", "백반", "김치볶음밥", "김밥", "라면", "냉면", "국밥")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

        textView.text = "음식 메뉴 추천해드립니다"

        button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val food = Random().nextInt(array.size)
                textView.text = array[food] + "을 추천합니다."
            }

        })

    }


}