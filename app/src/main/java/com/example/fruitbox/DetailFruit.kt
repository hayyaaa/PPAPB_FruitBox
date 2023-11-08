package com.example.fruitbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fruitbox.databinding.ActivityDetailFruitBinding

class DetailFruit : AppCompatActivity() {
    private lateinit var binding: ActivityDetailFruitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailFruitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val img = intent.getIntExtra("fruit_img", 0)

            fruitImg.setImageResource(img)

            fruitName.text = intent.getStringExtra("fruit_name")
            price.text = intent.getStringExtra("fruit_price")
            fruitDesc.text = intent.getStringExtra("fruit_desc")

        }
    }
}