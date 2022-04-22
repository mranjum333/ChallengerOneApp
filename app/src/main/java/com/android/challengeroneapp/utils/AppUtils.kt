package com.android.challengeroneapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.android.challengeroneapp.ECommerceApplication



fun isOnline(): Boolean {
    val connectivityManager = ECommerceApplication.APP_INSTANCE
        .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo as NetworkInfo
    return networkInfo.isConnected
}