package com.example.fruitbox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitbox.databinding.ItemFruitBinding

typealias OnClickFruit = (Fruit) -> Unit

class FruitAdapter(private val listFruits : List<Fruit>,
    private val onClickFruit: OnClickFruit) :
    RecyclerView.Adapter<FruitAdapter.ItemFruitViewHolder>() {

    inner class ItemFruitViewHolder(private val binding: ItemFruitBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data : Fruit) {
            with(binding) {
                fruitName.text = data.name
                fruitPrice.text = data.price
                fruitImg.setImageResource(data.image)

                itemView.setOnClickListener {
                    onClickFruit(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFruitViewHolder {
        val binding = ItemFruitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemFruitViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listFruits.size
    }

    override fun onBindViewHolder(holder: ItemFruitViewHolder, position: Int) {
        holder.bind(listFruits[position])
    }

}