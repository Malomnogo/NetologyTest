package com.malomnogo.netologytest.network

import android.content.Context
import android.util.Log
import com.malomnogo.netologytest.utils.FileLogger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class NetworkFileLogger(private val context: Context) : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        FileLogger.writeData(message, context)
        Log.d(OkHttpClient::class.java.simpleName, message)
    }
}