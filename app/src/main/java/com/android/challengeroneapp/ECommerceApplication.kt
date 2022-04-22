package com.android.challengeroneapp

import android.app.Application
import com.android.challengeroneapp.data.db.MyShopDatabase

lateinit var db: MyShopDatabase

class ECommerceApplication : Application() {

    companion object {
        lateinit var APP_INSTANCE: ECommerceApplication
    }

    init {
        APP_INSTANCE = this
    }

    override fun onCreate() {
        super.onCreate()
        db = MyShopDatabase.getInstance(this)
        APP_INSTANCE = this
    }
}