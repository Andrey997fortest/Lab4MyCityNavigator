package ru.istu.lab4mycitynavigator

object CityRepository {
    private val categories = listOf(
        Category(
            id = 1,
            titleResId = R.string.category_1_title,
            subtitleResId = R.string.category_1_subtitle,
        ),
        Category(
            id = 2,
            titleResId = R.string.category_2_title,
            subtitleResId = R.string.category_2_subtitle,
        ),
        Category(
            id = 3,
            titleResId = R.string.category_3_title,
            subtitleResId = R.string.category_3_subtitle,
        ),
        Category(
            id = 4,
            titleResId = R.string.category_4_title,
            subtitleResId = R.string.category_4_subtitle,
        ),
    )

    private val recommendations = listOf(
        Recommendation(
            id = 1,
            categoryId = 1,
            titleResId = R.string.recommendation_1_title,
            subtitleResId = R.string.recommendation_1_subtitle,
            detailsResId = R.string.recommendation_1_details,
            imageResId = R.drawable.place_01,
        ),
        Recommendation(
            id = 2,
            categoryId = 1,
            titleResId = R.string.recommendation_2_title,
            subtitleResId = R.string.recommendation_2_subtitle,
            detailsResId = R.string.recommendation_2_details,
            imageResId = R.drawable.place_02,
        ),
        Recommendation(
            id = 3,
            categoryId = 1,
            titleResId = R.string.recommendation_3_title,
            subtitleResId = R.string.recommendation_3_subtitle,
            detailsResId = R.string.recommendation_3_details,
            imageResId = R.drawable.place_03,
        ),
        Recommendation(
            id = 4,
            categoryId = 1,
            titleResId = R.string.recommendation_4_title,
            subtitleResId = R.string.recommendation_4_subtitle,
            detailsResId = R.string.recommendation_4_details,
            imageResId = R.drawable.place_04,
        ),
        Recommendation(
            id = 5,
            categoryId = 1,
            titleResId = R.string.recommendation_5_title,
            subtitleResId = R.string.recommendation_5_subtitle,
            detailsResId = R.string.recommendation_5_details,
            imageResId = R.drawable.place_05,
        ),
        Recommendation(
            id = 6,
            categoryId = 2,
            titleResId = R.string.recommendation_6_title,
            subtitleResId = R.string.recommendation_6_subtitle,
            detailsResId = R.string.recommendation_6_details,
            imageResId = R.drawable.place_06,
        ),
        Recommendation(
            id = 7,
            categoryId = 2,
            titleResId = R.string.recommendation_7_title,
            subtitleResId = R.string.recommendation_7_subtitle,
            detailsResId = R.string.recommendation_7_details,
            imageResId = R.drawable.place_07,
        ),
        Recommendation(
            id = 8,
            categoryId = 2,
            titleResId = R.string.recommendation_8_title,
            subtitleResId = R.string.recommendation_8_subtitle,
            detailsResId = R.string.recommendation_8_details,
            imageResId = R.drawable.place_08,
        ),
        Recommendation(
            id = 9,
            categoryId = 2,
            titleResId = R.string.recommendation_9_title,
            subtitleResId = R.string.recommendation_9_subtitle,
            detailsResId = R.string.recommendation_9_details,
            imageResId = R.drawable.place_09,
        ),
        Recommendation(
            id = 10,
            categoryId = 2,
            titleResId = R.string.recommendation_10_title,
            subtitleResId = R.string.recommendation_10_subtitle,
            detailsResId = R.string.recommendation_10_details,
            imageResId = R.drawable.place_10,
        ),
        Recommendation(
            id = 11,
            categoryId = 3,
            titleResId = R.string.recommendation_11_title,
            subtitleResId = R.string.recommendation_11_subtitle,
            detailsResId = R.string.recommendation_11_details,
            imageResId = R.drawable.place_11,
        ),
        Recommendation(
            id = 12,
            categoryId = 3,
            titleResId = R.string.recommendation_12_title,
            subtitleResId = R.string.recommendation_12_subtitle,
            detailsResId = R.string.recommendation_12_details,
            imageResId = R.drawable.place_12,
        ),
        Recommendation(
            id = 13,
            categoryId = 3,
            titleResId = R.string.recommendation_13_title,
            subtitleResId = R.string.recommendation_13_subtitle,
            detailsResId = R.string.recommendation_13_details,
            imageResId = R.drawable.place_13,
        ),
        Recommendation(
            id = 14,
            categoryId = 3,
            titleResId = R.string.recommendation_14_title,
            subtitleResId = R.string.recommendation_14_subtitle,
            detailsResId = R.string.recommendation_14_details,
            imageResId = R.drawable.place_14,
        ),
        Recommendation(
            id = 15,
            categoryId = 3,
            titleResId = R.string.recommendation_15_title,
            subtitleResId = R.string.recommendation_15_subtitle,
            detailsResId = R.string.recommendation_15_details,
            imageResId = R.drawable.place_15,
        ),
        Recommendation(
            id = 16,
            categoryId = 4,
            titleResId = R.string.recommendation_16_title,
            subtitleResId = R.string.recommendation_16_subtitle,
            detailsResId = R.string.recommendation_16_details,
            imageResId = R.drawable.place_16,
        ),
        Recommendation(
            id = 17,
            categoryId = 4,
            titleResId = R.string.recommendation_17_title,
            subtitleResId = R.string.recommendation_17_subtitle,
            detailsResId = R.string.recommendation_17_details,
            imageResId = R.drawable.place_17,
        ),
        Recommendation(
            id = 18,
            categoryId = 4,
            titleResId = R.string.recommendation_18_title,
            subtitleResId = R.string.recommendation_18_subtitle,
            detailsResId = R.string.recommendation_18_details,
            imageResId = R.drawable.place_18,
        ),
        Recommendation(
            id = 19,
            categoryId = 4,
            titleResId = R.string.recommendation_19_title,
            subtitleResId = R.string.recommendation_19_subtitle,
            detailsResId = R.string.recommendation_19_details,
            imageResId = R.drawable.place_19,
        ),
        Recommendation(
            id = 20,
            categoryId = 4,
            titleResId = R.string.recommendation_20_title,
            subtitleResId = R.string.recommendation_20_subtitle,
            detailsResId = R.string.recommendation_20_details,
            imageResId = R.drawable.place_20,
        ),
    )

    private val highlightIds = setOf(1, 6, 11, 16)

    fun getCategories(): List<Category> = categories
    fun getCategory(categoryId: Int): Category? = categories.firstOrNull { it.id == categoryId }
    fun getRecommendationsForCategory(categoryId: Int): List<Recommendation> = recommendations.filter { it.categoryId == categoryId }
    fun getRecommendation(categoryId: Int, recommendationId: Int): Recommendation? = recommendations.firstOrNull { it.categoryId == categoryId && it.id == recommendationId }
    fun getHighlights(): List<Recommendation> = recommendations.filter { highlightIds.contains(it.id) }
}
