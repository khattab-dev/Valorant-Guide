package com.slayer.common

import android.util.Log

fun Any?.printToLog(tag: String = "DEBUG_LOG") {
    Log.d(tag, toString())
}

fun hexColorToLong(hexColor: String): Long {
    return hexColor.toLong(16) and 0xFFFFFFFF
}