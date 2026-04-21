package ru.istu.lab4mycitynavigator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecommendationAdapter(
    private val items: List<Recommendation>,
    private val onClick: (Recommendation) -> Unit,
) : RecyclerView.Adapter<RecommendationAdapter.RecommendationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recommendation, parent, false)
        return RecommendationViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {
        holder.bind(items[position], onClick)
    }

    override fun getItemCount(): Int = items.size

    class RecommendationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.placeImage)
        private val titleView: TextView = itemView.findViewById(R.id.placeTitle)
        private val subtitleView: TextView = itemView.findViewById(R.id.placeSubtitle)

        fun bind(item: Recommendation, onClick: (Recommendation) -> Unit) {
            val context = itemView.context
            titleView.setText(item.titleResId)
            subtitleView.setText(item.subtitleResId)
            imageView.setImageResource(item.imageResId)
            imageView.contentDescription = context.getString(R.string.place_image_description, context.getString(item.titleResId))
            itemView.setOnClickListener { onClick(item) }
        }
    }
}
