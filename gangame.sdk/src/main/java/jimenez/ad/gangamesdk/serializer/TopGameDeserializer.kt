package jimenez.ad.gangamesdk.serializer

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import jimenez.ad.gangamesdk.TopGame
import java.lang.reflect.Type

class TopGameDeserializer : JsonDeserializer<TopGame> {


    companion object {
        const val BASE_IMG_URL = "http://cdn.akamai.steamstatic.com/steam/apps/%s/capsule_184x69.jpg"
    }


    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): TopGame {
        val gson = Gson()
        val topGame = gson.fromJson(json, TopGame::class.java)

        with(json.asJsonObject){
        val jsonGame = json.asJsonObject

        val appId = jsonGame["appid"].asInt.toString()

        val rawRating = jsonGame["score_rank"].asString
        val steamRating = if(rawRating.isEmpty()) 0 else Integer.parseInt(rawRating)
        val thumb = String.format(BASE_IMG_URL, appId)

        topGame.thumb = thumb
        topGame.steamRating = steamRating
        topGame.price = topGame.price / 100
        return topGame
    }
}
}