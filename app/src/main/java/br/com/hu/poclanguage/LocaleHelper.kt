package br.com.hu.poclanguage

import android.content.Context
import android.content.res.Configuration
import java.util.*
import android.R.id.edit
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.icu.util.ULocale.getLanguage
import android.os.Build








object LocaleHelper {


    var mEnglishFlag = "en"
    var mSpanishFlag = "es"
    var mPortugueseFlag = "pt"

    private val SELECTED_LANGUAGE = "Locale.Helper.Selected.Language"


    fun onAttach(context: Context): Context {
        val lang = getPersistedData(context, Locale.getDefault().language)
        return setLocale(context, lang!!)
    }

    fun onAttach(context: Context?, defaultLanguage: String): Context {
        val lang = getPersistedData(context, defaultLanguage)
        return setLocale(context, lang!!)
    }

    fun setLocale(context: Context?, language: String): Context {
        persist(context, language)
        return updateResources(context, language)
    }
    inline fun setNewLocale(context: Context?, language: String) {

        updateResources(context, language)
    }


    fun updateResources(context: Context?, language: String): Context {

        var contextFun = context

        var locale = Locale(language)
        Locale.setDefault(locale)

        var resources = context!!.resources
        var configuration = Configuration(resources.configuration)


        configuration.setLocale(locale)
        contextFun = context.createConfigurationContext(configuration)

        return contextFun
    }

    private fun getPersistedData(context: Context?, defaultLanguage: String): String? {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(SELECTED_LANGUAGE, defaultLanguage)
    }

    private fun persist(context: Context?, language: String) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putString(SELECTED_LANGUAGE, language)
        editor.apply()
    }

}