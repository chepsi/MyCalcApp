package com.chepsi.mycalcapp.domain

import android.app.Service
import android.content.Intent
import android.os.IBinder

class CalcService : Service() {
    override fun onBind(intent: Intent?): IBinder {
        return CalcServiceImp()
    }
}