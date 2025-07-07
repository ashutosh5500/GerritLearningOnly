package com.ashu.freecodecampmasterclass

import android.content.Context

class TokenManager constructor(context : Context) {
    private var pref = context.getSharedPreferences("token", Context.MODE_PRIVATE)
}