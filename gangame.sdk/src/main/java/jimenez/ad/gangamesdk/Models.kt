package jimenez.ad.gangamesdk

import com.google.gson.annotations.SerializedName

data class Deal(var title : String,
                var salePrice: Float,
                var normalPrice: Float,
                var metacriticScore: Int,
                @SerializedName("steamRatingPercent") var steamRating: Int,
                var thumb: String)

data class TopGame(@SerializedName("name") var title: String,
                   var publisher: String,
                   var steamRating: Int,
                   var owners: Int,
                   var price: Float,
                   var thumb: String)