package ru.istu.lab4mycitynavigator

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryFragment : Fragment(R.layout.fragment_category) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryId = requireArguments().getInt(ARG_CATEGORY_ID)
        val category = CityRepository.getCategory(categoryId) ?: return
        view.findViewById<TextView>(R.id.categoryTitle).setText(category.titleResId)
        view.findViewById<TextView>(R.id.categorySubtitle).setText(category.subtitleResId)

        val recyclerView: RecyclerView = view.findViewById(R.id.categoryRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = RecommendationAdapter(CityRepository.getRecommendationsForCategory(categoryId)) { recommendation ->
            findNavController().navigate(
                R.id.action_categoryFragment_to_recommendationDetailFragment,
                RecommendationDetailFragment.bundle(categoryId, recommendation.id),
            )
        }
    }

    companion object {
        private const val ARG_CATEGORY_ID = "categoryId"
        fun bundle(categoryId: Int) = bundleOf(ARG_CATEGORY_ID to categoryId)
    }
}
