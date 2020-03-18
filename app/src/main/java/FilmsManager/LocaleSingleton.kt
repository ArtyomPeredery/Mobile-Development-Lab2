package com.bsuir.FilmsManager

class LocaleSingleton {
    var SelectedLocale: String = "en"

    companion object{
        val instance = LocaleSingleton()
    }
}