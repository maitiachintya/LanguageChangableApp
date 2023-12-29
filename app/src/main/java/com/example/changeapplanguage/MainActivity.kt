package com.example.changeapplanguage

import android.app.Activity
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.changeapplanguage.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val languages = arrayOf("Selected Language", "Bengali", "Hindi", "English","Japanese","Chinese","Italian")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.selectLng.adapter = adapter
        binding.selectLng.setSelection(0)
        binding.selectLng.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedLanguage = parent?.getItemAtPosition(position).toString()
                if (selectedLanguage.equals("English")) {
                    setLocal(this@MainActivity, "en")
                    finish()
                    startActivity(getIntent())
                }
                else if(selectedLanguage.equals("Bengali")){
                    setLocal(this@MainActivity, "bn")
                    finish()
                    startActivity(getIntent())
                }
                else if(selectedLanguage.equals("Hindi")){
                    setLocal(this@MainActivity, "hn")
                    finish()
                    startActivity(getIntent())
                }
                else if(selectedLanguage.equals("Chinese")){
                    setLocal(this@MainActivity, "chn")
                    finish()
                    startActivity(getIntent())
                }
                else if(selectedLanguage.equals("Italian")){
                    setLocal(this@MainActivity, "it")
                    finish()
                    startActivity(getIntent())
                }
                else if(selectedLanguage.equals("Japanese")){
                    setLocal(this@MainActivity, "jn")
                    finish()
                    startActivity(getIntent())
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    private fun setLocal(activity: Activity, langCode: String) {
        val locals = Locale(langCode)
        Locale.setDefault(locals)
        val resources = activity.resources
        val config: Configuration = resources.configuration
        config.setLocale(locals)
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}