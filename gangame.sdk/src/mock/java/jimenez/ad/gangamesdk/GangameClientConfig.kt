package jimenez.ad.gangamesdk

import okhttp3.OkHttpClient
import retrofit2.Retrofit

class GangameClientConfig : GangameApiConfig (){

    companion object {
        const val DEFAULT_RESPONSE = "{\"status\" : \"success\"}"
    }

    override fun setupConfig(builder: Retrofit.Builder) {
        val client: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(MockResponseInterceptor(getMockresponses(), DEFAULT_RESPONSE))
                .build()

        builder.client(client)
    }

    private fun getMockresponses(): HashMap<String,String>{
       return hashMapOf<String, String>(
               Pair(Routes.GET_DEALS, MockResponses.DEALS_RESPONSE),
               Pair(Routes.GET_MOST_OWNED_GAMES, MockResponses.TOP_100_GAMES),
               Pair(Routes.GET_TOP_100_GAMES, MockResponses.TOP_100_GAMES)
       )
    }
}