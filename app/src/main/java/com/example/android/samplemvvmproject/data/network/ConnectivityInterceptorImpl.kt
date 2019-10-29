package com.example.android.samplemvvmproject.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.android.samplemvvmproject.internal.NoConnectivityExcpetion
import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityInterceptorImpl(
    context: Context
) : ConnectivityInterceptor {
    private val appContext = context.applicationContext
    @RequiresApi(Build.VERSION_CODES.M)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isOnline()) throw NoConnectivityExcpetion()

        return chain.proceed(chain.request())
    }

    /**
     * Helper Function to check the internet connection
     */
    @RequiresApi(Build.VERSION_CODES.M)
    private fun isOnline(): Boolean {
        val connectivityManager =
            appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }
}