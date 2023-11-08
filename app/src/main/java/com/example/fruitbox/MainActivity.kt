package com.example.fruitbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruitbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

        var adapterFruit = FruitAdapter(generateFruitsData()) {
            fruit ->
            Toast.makeText(this@MainActivity, "You clicked on ${fruit.name}",
                Toast.LENGTH_SHORT).show()

            val intent = Intent(this, DetailFruit::class.java)

            intent.putExtra("fruit_name", fruit.name)
            intent.putExtra("fruit_price", fruit.price)
            intent.putExtra("fruit_desc", fruit.desc)
            intent.putExtra("fruit_img", fruit.image)
            startActivity(intent)
        }

        with(binding) {
            rvFruit.apply {
                adapter = adapterFruit
                layoutManager = LinearLayoutManager(this@MainActivity)

            }
        }
    }

    fun generateFruitsData() : List<Fruit> {
        return listOf(
            Fruit(R.drawable.apple, "Apple", "$3.31 / kg", "Apple is a pomaceous fruit produced by an apple tree. The fruit is typically pomaceous, with a fleshy pulp that surrounds a core of five carpels containing seeds. Apples come in a wide variety of colors, including red, green, yellow, and pink. Apples can be eaten fresh, cooked, or juiced. They are also used to make a variety of products, including cider, vinegar, and jam. Apples are a good source of dietary fiber, vitamin C, and potassium. They are also a good source of antioxidants, which protect the body against damage from free radicals. Apples have been linked to a number of health benefits, including reduced risk of heart disease, stroke, and cancer."),
            Fruit(R.drawable.avocado, "Avocado", "$6.67 /kg", "Avocado is a pear-shaped fruit that is grown in tropical and subtropical climates around the world. The avocado is a drupe, which is a type of fruit that has a single seed surrounded by a fleshy pulp. The avocado's flesh is typically green or yellow, and it has a buttery texture and a rich, nutty flavor. Avocados are a good source of dietary fiber, potassium, and vitamins C, E, and K. They are also a good source of healthy fats, including monounsaturated and polyunsaturated fats. Avocados have been linked to a number of health benefits, including reduced risk of heart disease, stroke, and cancer."),
            Fruit(R.drawable.banana, "Banana", "$1.11 /kg", "Banana is an elongated, edible fruit – botanically a berry – produced by several kinds of large herbaceous flowering plants in the genus Musa. The fruit is variable in size, color, and firmness, but is usually elongated and curved, with soft flesh rich in starch covered with a rind, which may be green, yellow, red, purple, or brown when ripe. The fruits grow upward in clusters near the top of the plant. Bananas are an important food crop in tropical and subtropical regions. They are a good source of dietary fiber, potassium, vitamin C, and vitamin B6. They are also a good source of energy, with one banana providing about 105 calories."),
            Fruit(R.drawable.grape, "Grape", "$4.44 /kg", "Grape is a fruit, botanically a berry, of the deciduous woody vines of the flowering plant genus Vitis. Eaten fresh or in dried form (as raisins, currants and sultanas), grapes also hold cultural significance in many parts of the world, particularly for their role in winemaking. Other grape-derived products include various types of jam, jelly, juice, vinegar and oil. Grapes are a type of fruit that grow in clusters of 15 to 300, and can be crimson, black, dark blue, yellow, green, orange, and pink. Grapes are a good source of vitamins, minerals, and antioxidants. They are a good source of vitamin C, potassium, and fiber. They also contain antioxidants, which help protect cells from damage."),
            Fruit(R.drawable.mango, "Mango", "$4.44 /kg", "Mango is a starchy tropical fruit produced by trees of the Anacardiaceae family, that are native to South Asia but are now cultivated worldwide in tropical and subtropical regions. Mangoes are typically oval or kidney-shaped, with a smooth, leathery skin that ranges in color from green to yellow to red or purple when ripe. The flesh of the mango is typically orange or yellow, and has a sweet, juicy flavor. Mangoes are a good source of vitamins, minerals, and antioxidants. They are a good source of vitamin C, potassium, and fiber. They also contain antioxidants, which help protect cells from damage."),
            Fruit(R.drawable.orange, "Orange", "$2.22 /kg", "Orange is a citrus fruit native to Southeast Asia. The orange is a good source of vitamin C, potassium, and fiber. It also contains antioxidants, which help protect cells from damage. Oranges have been linked to a number of health benefits, including reduced risk of heart disease, stroke, and cancer. Oranges are typically round or oval in shape, with a smooth, shiny skin that ranges in color from green to orange to red when ripe. The flesh of the orange is typically divided into segments, which are filled with juice. Oranges can be eaten fresh, juiced, or used in a variety of recipes."),
            Fruit(R.drawable.pineapple, "Pineapple", "$5.56 /kg", "Pineapple is a tropical fruit that is native to South America. Pineapples are typically oval or cylindrical in shape, with a tough, spiny skin that ranges in color from green to yellow to brown when ripe. The flesh of the pineapple is typically yellow or gold, and has a sweet, tangy flavor. Pineapples are a good source of vitamins, minerals, and enzymes. They are a good source of vitamin C, potassium, and manganese. They also contain enzymes that help to digest food. Pineapples have been linked to a number of health benefits, including reduced risk of heart disease, stroke, and cancer."),
            )
    }
}