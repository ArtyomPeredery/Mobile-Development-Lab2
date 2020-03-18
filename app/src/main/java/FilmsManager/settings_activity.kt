package com.bsuir.FilmsManager
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings_activity.*
import java.util.*
import kotlin.collections.ArrayList
import android.widget.*


class settings_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        resources.configuration.setLocale(Locale(LocaleSingleton.instance.SelectedLocale))

        resources.updateConfiguration(resources.configuration, resources.displayMetrics)
        theme.applyStyle(Preferences(this).getFontFamily().getResId(), true);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_activity)

        val settings = getSharedPreferences("MyAppSett", AppCompatActivity.MODE_PRIVATE)
        val value_bar = settings.edit()
        val bar_value = 0
        settings.getInt("bar_progress", bar_value)


        LANGUAGES.add(resources.getString(R.string.settings_en))
        LANGUAGES.add(resources.getString(R.string.settings_by))

        FONT_FAMILIES.addAll(FontFamily.values().map{value -> value.getTitle()})
        LanguagesMap.add("en")
        LanguagesMap.add("by")


        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item, LANGUAGES
        )

        val languagesSpinner = findViewById<Spinner>(R.id.languages_dropdown)
        languagesSpinner.adapter = adapter
        languagesSpinner.isSelected = false;
        languagesSpinner.setSelection(0,false)


        val fontFamiliesSpinner = findViewById<Spinner>(R.id.font_family_spinner)


        fontFamiliesSpinner.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item, FONT_FAMILIES
        )

        languagesSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(LanguagesMap.indexOf(resources.configuration.locale.language) != position){
                    LocaleSingleton.instance.SelectedLocale = LanguagesMap[position]
                    finish()
                    startActivity(intent)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        };

        var prefs = Preferences(this)


        fontFamiliesSpinner.setSelection(prefs.getFontFamily().ordinal);

        fontFamiliesSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                prefs.setFontFamily(FontFamily.values()[id.toInt()])

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        };

        ApplyBtn.setOnClickListener {
            MainActivity.instance?.filter("","","");
            finish()
        }

        val startvalue = 1f //начальное значение размера шрифта
        val step = 0.1f //шаг увеличения коэффициента
        var sizecoef = 0//выбранный коэффициент
        var selectcoef:Int

        selectcoef = settings.getInt("size_coef", 2)
        FontSizeBar.setProgress(selectcoef)
        CurrentFontSize.text =  selectcoef.toString()

        FontSizeBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(FontSizeBar:SeekBar, progress:Int, fromUser:Boolean) {
                sizecoef = FontSizeBar.progress
                selectcoef = FontSizeBar.progress
                CurrentFontSize.text =  sizecoef.toString()
            }
            override fun onStartTrackingTouch(seekBar:SeekBar) {}
            override fun onStopTrackingTouch(seekBar:SeekBar) {

                val settings = getSharedPreferences("MyAppSett", AppCompatActivity.MODE_PRIVATE)
                val value_add = settings.edit()
                value_add.putInt("size_coef", sizecoef)
                value_add.apply()
                val res = resources
                val coef = startvalue + sizecoef * step //новый коэффициент увеличения шрифта
                val configuration = Configuration(res.getConfiguration())
                configuration.fontScale = coef
                res.updateConfiguration(configuration, res.getDisplayMetrics())

                val refreshActivity = intent
                finish()
                startActivity(refreshActivity)


            }


        })





    }
                private var LANGUAGES = ArrayList<String>()
                private var FONT_FAMILIES = ArrayList<String>()
                private val LanguagesMap = ArrayList<String>()

}
