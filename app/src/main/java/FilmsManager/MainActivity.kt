package com.bsuir.FilmsManager

import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bsuir.FilmsManager.models.Cartoon
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.Locale;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.Configuration;
import com.bsuir.cartooons.R


class MainActivity : AppCompatActivity(), IFilterable, View.OnClickListener {

    override fun onClick(p0: View?) {
        if(p0 != null){
            this.onViewVideo(p0)
        }
        val refreshActivity = intent
        finish()
        startActivity(refreshActivity)
    }

    override fun filter(author: String, minutesDuration: String, hoursDuration: String) {
        filteredCartoons = DataSource.createDataSet(applicationContext, jsonSerializer)

        if(author != ""){
            filteredCartoons = filteredCartoons?.filter { cartoon -> cartoon.author == author }
        }

        if(minutesDuration != "" || hoursDuration != ""){
            var minutesDurationInt = 0;
            var hoursDurationInt = 0;

            try {
                minutesDurationInt = minutesDuration.toInt()
            }
            catch (e: Exception){

            }

            try {
                hoursDurationInt = hoursDuration.toInt()
            }
            catch (e: Exception){

            }

            if(minutesDurationInt != 0 || hoursDurationInt != 0){
                val seconds = minutesDurationInt * 60 + hoursDurationInt * 60 * 60
                filteredCartoons = filteredCartoons?.filter { cartoon -> cartoon.durationSeconds <= seconds }
            }
        }
        cartoonRecyclerAdapter.submitList(this, filteredCartoons!!)
        cartoonRecyclerAdapter.notifyDataSetChanged()
        recycler_view.adapter = cartoonRecyclerAdapter
    }

    companion object{
        var instance: MainActivity? = null
    }

    private lateinit var cartoonRecyclerAdapter: CartoonRecyclerAdapter
    private var jsonSerializer: JsonFileSerializer = JsonFileSerializer()


    var previousLocale: String = ""
    var previousFont: Int = 0;
    var previousFontFamily: Int = 0;


    override fun onResume() {
        val step = 0.1f
        val settings = getSharedPreferences("MyAppSett", AppCompatActivity.MODE_PRIVATE)
        val sizecoef = settings.getInt("size_coef", 2)
        val res = resources
        val coef = 1f + sizecoef * step //новый коэффициент увеличения шрифта
        val configuration = Configuration(res.getConfiguration())
        configuration.fontScale = coef
        res.updateConfiguration(configuration, res.getDisplayMetrics())
        super.onRestart()
        super.onResume()
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        val step = 0.1f
        val settings = getSharedPreferences("MyAppSett", AppCompatActivity.MODE_PRIVATE)
        val sizecoef = settings.getInt("size_coef", 2)
        val res = resources
        val coef = 1f + sizecoef * step //новый коэффициент увеличения шрифта
        val configuration = Configuration(res.getConfiguration())
        configuration.fontScale = coef
        res.updateConfiguration(configuration, res.getDisplayMetrics())




        instance = this
        previousLocale = LocaleSingleton.instance.SelectedLocale
        previousFontFamily = Preferences(this).getFontFamily().getResId()

        resources.configuration.setLocale(Locale(previousLocale))
        resources.updateConfiguration(resources.configuration, resources.displayMetrics)
        theme.applyStyle(previousFont, true);
        theme.applyStyle(previousFontFamily, true);
        val refreshActivity = intent

        startActivity(refreshActivity)

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        initRecyclerView()
        addDataSet(jsonSerializer)





    }

    private fun onViewVideo(view: View){

        val itemPosition = recycler_view.getChildLayoutPosition(view)
        var cartoon = filteredCartoons?.get(itemPosition)

        if(cartoon == null){
            return
        }

        val intent = Intent(this, video_activity::class.java).apply {
            putExtra("URL", cartoon.link)
        }


        startActivity(intent)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.settings -> {
                val intent = Intent(this, settings_activity::class.java).apply {

                }
                startActivity(intent)
            }
            R.id.filter -> {
                val intent = Intent(this, filter_activity::class.java).apply {

                }
                startActivity(intent)
            }

        }

        return true
    }




    var cartoons: ArrayList<Cartoon>? = null
    var filteredCartoons: List<Cartoon>? = null

    private fun addDataSet(jsonSerializer: JsonFileSerializer) {
        cartoons = DataSource.createDataSet(applicationContext, jsonSerializer)
        filteredCartoons = DataSource.createDataSet(applicationContext, jsonSerializer)
        cartoonRecyclerAdapter.submitList(this, filteredCartoons!!)
    }

    private fun initRecyclerView(){

        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)
            cartoonRecyclerAdapter = CartoonRecyclerAdapter()
            adapter = cartoonRecyclerAdapter
        }
    }


}