package ru.istu.lab4mycitynavigator

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class RecommendationDetailFragment : Fragment(R.layout.fragment_recommendation_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryId = requireArguments().getInt(ARG_CATEGORY_ID)
        val recommendationId = requireArguments().getInt(ARG_RECOMMENDATION_ID)
        val recommendation = CityRepository.getRecommendation(categoryId, recommendationId) ?: return
        view.findViewById<TextView>(R.id.detailTitle).setText(recommendation.titleResId)
        view.findViewById<TextView>(R.id.detailSubtitle).setText(recommendation.subtitleResId)
        view.findViewById<TextView>(R.id.detailBody).setText(recommendation.detailsResId)
        view.findViewById<ImageView>(R.id.detailImage).apply {
            setImageResource(recommendation.imageResId)
            contentDescription = getString(R.string.place_image_description, getString(recommendation.titleResId))
        }
    }

    companion object {
        private const val ARG_CATEGORY_ID = "categoryId"
        private const val ARG_RECOMMENDATION_ID = "recommendationId"
        fun bundle(categoryId: Int, recommendationId: Int) = bundleOf(
            ARG_CATEGORY_ID to categoryId,
            ARG_RECOMMENDATION_ID to recommendationId,
        )
    }
}
