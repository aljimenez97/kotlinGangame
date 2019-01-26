package jimenez.ad.gangame.data

import jimenez.ad.gangame.Deal

object DealMapper {

    fun fromSdk(deal: jimenez.ad.gangamesdk.Deal): Deal{
        return Deal(deal.title,
                deal.salePrice,
                deal.salePrice,
                deal.metacriticScore,
                deal.steamRating,
                deal.thumb)
    }
}