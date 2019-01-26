package jimenez.ad.gangamesdk

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class GangameClientConfig: GangameApiConfig {
    override fun setupConfig(builder: Retrofit.Builder) {
        if (BuildConfig.DEBUG) {
            val okHttpClient = OkHttpClient().newBuilder()
                    .addInterceptor(HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()

            builder.client(okHttpClient)
        }
    }
}