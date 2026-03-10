package com.pacote.app

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class BanCalculatorApp : Application() {

    companion object {
        private const val PREFS_NAME = "BanCalculatorPrefs"
        private const val IS_BANNED_KEY = "isBanned"

        private lateinit var sharedPreferences: SharedPreferences

        fun isBanned(context: Context): Boolean {
            if (!::sharedPreferences.isInitialized) {
                sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            }
            return sharedPreferences.getBoolean(IS_BANNED_KEY, false)
        }

        fun setBanned(context: Context, isBanned: Boolean) {
            if (!::sharedPreferences.isInitialized) {
                sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            }
            sharedPreferences.edit().putBoolean(IS_BANNED_KEY, isBanned).apply()
        }
    }

    override fun onCreate() {
        super.onCreate()
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }
}