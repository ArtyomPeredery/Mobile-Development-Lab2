package com.bsuir.FilmsManager

interface IFilterable {
    fun filter(author: String, minutesDuration: String, hoursDuration: String)
}