package com.example.testapp.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.testapp.data.model.Card

class HomeAdapter(
    private val data: List<Card>,
    private val onItemClick: (Card) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_TEXT = 1
        const val TYPE_TITLE_DESCRIPTION = 2
        const val TYPE_IMAGE_TITLE_DESCRIPTION = 3
    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position].card_type) {
            "text" -> TYPE_TEXT
            "title_description" -> TYPE_TITLE_DESCRIPTION
            "image_title_description" -> TYPE_IMAGE_TITLE_DESCRIPTION
            else -> TYPE_TEXT // Fallback
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_TEXT -> TextCardViewHolder(
                LayoutInflater.from(parent.context).inflate(com.example.testapp.R.layout.item_text_card, parent, false)
            )
            TYPE_TITLE_DESCRIPTION -> TitleDescriptionCardViewHolder(
                LayoutInflater.from(parent.context).inflate(com.example.testapp.R.layout.item_title_description_card, parent, false)
            )
            TYPE_IMAGE_TITLE_DESCRIPTION -> ImageTitleDescriptionCardViewHolder(
                LayoutInflater.from(parent.context).inflate(com.example.testapp.R.layout.item_image_title_description_card, parent, false)
            )
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val card = data[position]
        when (holder) {
            is TextCardViewHolder -> holder.bind(card)
            is TitleDescriptionCardViewHolder -> holder.bind(card)
            is ImageTitleDescriptionCardViewHolder -> holder.bind(card)
        }
    }

    override fun getItemCount(): Int = data.size

    inner class TextCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textValue: TextView = view.findViewById(com.example.testapp.R.id.text_value)
        fun bind(card: Card) {
            textValue.text = card.card.value
            textValue.setTextColor(Color.parseColor(card.card.attributes?.text_color ?: "#000000"))
            textValue.textSize = card.card.attributes?.font?.size?.toFloat() ?: 16f
            itemView.setOnClickListener { onItemClick(card) }
        }
    }

    inner class TitleDescriptionCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titleText: TextView = view.findViewById(com.example.testapp.R.id.title_text)
        private val descriptionText: TextView = view.findViewById(com.example.testapp.R.id.description_text)
        fun bind(card: Card) {
            titleText.text = card.card.title?.value
            titleText.setTextColor(Color.parseColor(card.card.title?.attributes?.text_color ?: "#000000"))
            titleText.textSize = card.card.title?.attributes?.font?.size?.toFloat() ?: 16f

            descriptionText.text = card.card.description?.value
            descriptionText.setTextColor(Color.parseColor(card.card.description?.attributes?.text_color ?: "#000000"))
            descriptionText.textSize = card.card.description?.attributes?.font?.size?.toFloat() ?: 14f

            itemView.setOnClickListener { onItemClick(card) }
        }
    }

    inner class ImageTitleDescriptionCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image: ImageView = view.findViewById(com.example.testapp.R.id.image)
        private val titleText: TextView = view.findViewById(com.example.testapp.R.id.image_title)
        private val descriptionText: TextView = view.findViewById(com.example.testapp.R.id.image_description)
        fun bind(card: Card) {
            // Using Coil for image loading
            image.load(card.card.image?.url)
            titleText.text = card.card.title?.value
            titleText.setTextColor(Color.parseColor(card.card.title?.attributes?.text_color ?: "#FFFFFF"))
            titleText.textSize = card.card.title?.attributes?.font?.size?.toFloat() ?: 16f

            descriptionText.text = card.card.description?.value
            descriptionText.setTextColor(Color.parseColor(card.card.description?.attributes?.text_color ?: "#FFFFFF"))
            descriptionText.textSize = card.card.description?.attributes?.font?.size?.toFloat() ?: 14f

            itemView.setOnClickListener { onItemClick(card) }
        }
    }
}
