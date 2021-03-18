package com.example.androiddevchallenge.data

data class Model(
    val title: String,
    val url: String
)

val pictureList = listOf(
    Model(
        "Desert chic",
        "https://images.pexels.com/photos/2132227/pexels-photo-2132227.jpeg?cs=srgb&dl=pexels-quang-nguyen-vinh-2132227.jpg&fm=jpg"
    ),
    Model(
        "Tiny terrariums",
        "https://images.pexels.com/photos/1400375/pexels-photo-1400375.jpeg?cs=srgb&dl=pexels-katarzyna-modrzejewska-1400375.jpg&fm=jpg"
    ),
    Model(
        "Jungle vibes",
        "https://images.pexels.com/photos/5699665/pexels-photo-5699665.jpeg?cs=srgb&dl=pexels-volkan-vardar-5699665.jpg&fm=jpg"
    ),
    Model(
        "Easy care",
        "https://images.pexels.com/photos/6208086/pexels-photo-6208086.jpeg?cs=srgb&dl=pexels-%D0%B2%D0%BB%D0%B0%D0%B4%D0%B8%D0%BC%D0%B8%D1%80-%D0%B3%D0%BB%D0%B0%D0%B4%D0%BA%D0%BE%D0%B2-6208086.jpg&fm=jpg",
    ),
    Model(
        "Statements",
        "https://images.pexels.com/photos/3511755/pexels-photo-3511755.jpeg?cs=srgb&dl=pexels-sidnei-maia-3511755.jpg&fm=jpg"
    ),
    Model(
        "Monstera",
        "https://images.pexels.com/photos/3097770/pexels-photo-3097770.jpeg?cs=srgb&dl=pexels-huy-phan-3097770.jpg&fm=jpg"
    ),
    Model(
        "Aglaonema",
        "https://images.pexels.com/photos/4751978/pexels-photo-4751978.jpeg?cs=srgb&dl=pexels-karolina-grabowska-4751978.jpg&fm=jpg"
    ),
    Model(
        "Pease lily",
        "https://images.pexels.com/photos/4425201/pexels-photo-4425201.jpeg?cs=srgb&dl=pexels-melvin-vito-4425201.jpg&fm=jpg"
    ),
    Model(
        "Fiddle leaf",
        "https://images.pexels.com/photos/6208087/pexels-photo-6208087.jpeg?cs=srgb&dl=pexels-%D0%B2%D0%BB%D0%B0%D0%B4%D0%B8%D0%BC%D0%B8%D1%80-%D0%B3%D0%BB%D0%B0%D0%B4%D0%BA%D0%BE%D0%B2-6208087.jpg&fm=jpg"
    ),
    Model(
        "Snake plant",
        "https://images.pexels.com/photos/2123482/pexels-photo-2123482.jpeg?cs=srgb&dl=pexels-fabian-stroobants-2123482.jpg&fm=jpg"
    ),
    Model(
        "Pothos",
        "https://images.pexels.com/photos/1084199/pexels-photo-1084199.jpeg?cs=srgb&dl=pexels-faraz-ahmad-1084199.jpg&fm=jpg"
    )
)

object Repository {
    fun get(): List<Model> {
        return pictureList
    }
}