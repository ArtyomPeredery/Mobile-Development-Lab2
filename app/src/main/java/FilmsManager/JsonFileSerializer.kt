package com.bsuir.FilmsManager

import android.content.Context
import com.bsuir.FilmsManager.models.Cartoon
import com.google.gson.GsonBuilder
import java.io.*
import com.google.gson.reflect.TypeToken
import java.lang.Exception


class JsonFileSerializer{

    private val jsonBuilder : GsonBuilder = GsonBuilder();
    private val filePath = "cartoons.json"
    private var outputStream: FileOutputStream? = null
    private var file : File? = null

    fun serialize(context: Context, cartoons: ArrayList<Cartoon>) {
        var json = jsonBuilder.create().toJson(cartoons);

        if(outputStream == null || file == null){
            createFile(context)
            outputStream = FileOutputStream(file, false)
        }

        val writer = OutputStreamWriter(outputStream)

        writer.write(json);
    }

    fun createFile(context: Context){
        file = File(context.getExternalFilesDir(null)?.absolutePath, "cartoons.json")

        if(file?.isDirectory!!){
            file?.delete()
            file = File(context.getExternalFilesDir(null)?.absolutePath, "cartoons.json")
        }

        file?.createNewFile()
    }

    fun deserialize(context: Context) : ArrayList<Cartoon>? {
        val listType = object : TypeToken<Array<Cartoon>>() {
        }.type;

        if(file == null){
            createFile(context)
        }

        try {
            val returnValue = jsonBuilder.create().fromJson<ArrayList<Cartoon>>(
                InputStreamReader(FileInputStream(file)),
                listType);

            return returnValue
        }
        catch (e : Exception){
            println(e.localizedMessage)

            return null
        }
    }
}