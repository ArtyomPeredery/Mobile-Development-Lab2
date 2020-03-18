package com.bsuir.FilmsManager

import android.content.Context
import android.content.SharedPreferences



class Preferences {
    private val FONT_FAMILY = "FONT_FAMILY"

    private val context: Context

    constructor(context: Context){
        this.context = context
    }

    protected fun open(): SharedPreferences {
        return context.getSharedPreferences("prefs", Context.MODE_PRIVATE)
    }

    protected fun edit(): SharedPreferences.Editor {
        return open().edit()
    }


    fun getFontFamily(): FontFamily {
        return FontFamily.valueOf(
            open().getString(FONT_FAMILY, FontFamily.SansSerif.name)

        )
    }

    fun setFontFamily(family: FontFamily){
        edit().putString(FONT_FAMILY, family.name).commit()

    }

}