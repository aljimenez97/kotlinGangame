package jimenez.ad.gangame.data

import jimenez.ad.gangame.TopGame
import java.text.FieldPosition

object TopGameMapper {

    fun fromSdk(topGame: jimenez.ad.gangamesdk.TopGame, position: Int): TopGame{
        return TopGame(topGame.title,
                topGame.owners,
                topGame.steamRating,
                topGame.publisher,
                topGame.price,
                position,
                topGame.thumb)
    }
}