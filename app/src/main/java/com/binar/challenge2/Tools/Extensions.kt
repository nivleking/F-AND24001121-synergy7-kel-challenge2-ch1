package com.binar.challenge2.Tools

import android.content.Context
import android.content.Intent
import android.os.Bundle

fun goToAnotherActivityWithBundle(context: Context, anotherActivity: Class<*>, bundle: Bundle) {
    val intent = Intent(context, anotherActivity)
    intent.putExtras(bundle)
    context.startActivity(intent)
}