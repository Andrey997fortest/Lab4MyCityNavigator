package ru.istu.lab4mycitynavigator

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HighlightsFragment : Fragment(R.layout.fragment_highlights) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.highlightsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = RecommendationAdapter(CityRepository.getHighlights()) { recommendation ->
            findNavController().navigate(
                R.id.action_highlightsFragment_to_recommendationDetailFragment,
                RecommendationDetailFragment.bundle(recommendation.categoryId, recommendation.id),
            )
        }
    }
}
