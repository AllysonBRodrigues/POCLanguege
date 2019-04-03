package br.com.hu.poclanguage

import android.content.Context
import android.content.res.Configuration
import java.util.*


object LocaleHelper {


    var mEnglishFlag = "en"
    var mSpanishFlag = "es"
    var mPortugueseFlag = "pt"

    fun setLocale(context: Context?): Context {
        return updateResources(context!!, Locale.getDefault().language)
    }

    inline fun setNewLocale(context: Context, language: String) {

        updateResources(context, language)
    }


    fun updateResources(context: Context, language: String): Context {

        var contextFun = context

        var locale = Locale(language)
        Locale.setDefault(locale)

        var resources = context.resources
        var configuration = Configuration(resources.configuration)


        configuration.setLocale(locale)
        contextFun = context.createConfigurationContext(configuration)

        return contextFun
    }
}