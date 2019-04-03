package br.com.hu.poclanguage

import android.content.Context
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.os.ConfigurationCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loc = ConfigurationCompat.getLocales(Resources.getSystem().configuration).get(0)

        val loc1 = Locale.getDefault().country

        var a = loc.getLanguage()
        var b = loc.getISO3Language()
        var c = loc.getCountry()
        var d = loc.getISO3Country()
        var e = loc.getDisplayCountry()
        var f = loc.getDisplayName()
        var g = loc.toString()
        var h = loc.getDisplayLanguage()

        var currency = Currency.getInstance(loc)


        portugues.setOnClickListener {
            LocaleHelper.setNewLocale(this, LocaleHelper.mPortugueseFlag)
            recreate()
        }

        ingles.setOnClickListener {
            LocaleHelper.setNewLocale(this, LocaleHelper.mEnglishFlag)
            recreate()
        }

        espanhol.setOnClickListener {
            LocaleHelper.setNewLocale(this, LocaleHelper.mSpanishFlag)
            recreate()
        }


    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(LocaleHelper.setLocale(newBase))
    }

}
