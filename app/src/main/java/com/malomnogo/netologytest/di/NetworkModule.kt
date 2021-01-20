package com.malomnogo.netologytest.di

import android.net.Uri
import com.google.gson.*
import com.malomnogo.netologytest.BuildConfig
import com.malomnogo.netologytest.network.NetworkFileLogger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type

private const val TAG_URL = "TAG_URL"
private const val OK_HTTP_TAG = "OK_HTTP_TAG"

val networkModule = module {

    single(named(TAG_URL)) { BuildConfig.BASE_URL }
    single { getGson() }
    single { GsonConverterFactory.create(get()) } bind Converter.Factory::class
    single { RxJava3CallAdapterFactory.create() } bind CallAdapter.Factory::class
    single { NetworkFileLogger(get()) }

    single(named(OK_HTTP_TAG)) {
        val logger = HttpLoggingInterceptor(logger = get<NetworkFileLogger>()).apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
    } bind OkHttpClient::class

    single {
        Retrofit.Builder()
            .baseUrl(get(named(TAG_URL)) as String)
            .client(get(named(OK_HTTP_TAG)))
            .addConverterFactory(get())
            .addCallAdapterFactory(get())
            .build()
    }
}

fun getGson(): Gson {
    val builder = GsonBuilder()
        .registerTypeAdapter(Uri::class.java, UriDeserializer())
        .setPrettyPrinting()
    return builder.create()
}

class UriDeserializer : JsonDeserializer<Uri> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Uri {
        return Uri.parse(json?.asString)
    }
}