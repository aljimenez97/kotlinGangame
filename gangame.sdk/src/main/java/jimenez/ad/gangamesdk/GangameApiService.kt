package jimenez.ad.gangamesdk

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import jimenez.ad.gangamesdk.serializer.ListTopGameDeserializer
import jimenez.ad.gangamesdk.serializer.TopGameDeserializer
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GangameApiService(val apiConfig: GangameApiConfig = GangameClientConfig()) {

    val apiClient: RetrofitGangameApi

    init {

        val tokenType = object : TypeToken<ArrayList<TopGame>>(){}.type
        val gson = GsonBuilder()
                .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
                .registerTypeAdapter(tokenType, ListTopGameDeserializer())
                .create()



        val apiClientConfig =
            Retrofit.Builder()
                .baseUrl(Routes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

        apiConfig.setupConfig(apiClientConfig)

        apiClient= apiClientConfig.build().create(RetrofitGangameApi::class.java)
    }
}