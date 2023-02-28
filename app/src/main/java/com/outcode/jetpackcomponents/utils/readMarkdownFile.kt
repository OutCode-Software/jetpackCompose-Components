package com.outcode.jetpackcomponents.utils

import android.content.Context

fun readMarkdownFile(context: Context, fileName: String): String {
    return context.assets.open(fileName).bufferedReader().use {
        it.readText()
    }
}