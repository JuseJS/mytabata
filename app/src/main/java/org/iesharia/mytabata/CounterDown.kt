package org.iesharia.mytabata

import android.os.CountDownTimer
import android.util.Log

class CounterDown(var segundos: Int, var loquehacealhacertick: (Long) -> Unit) {
    private var counterState : Boolean = false

    val myCounter = object : CountDownTimer((segundos * 1000L), 1000) {

        override fun onTick(millisUntilFinished: Long) {
            if (counterState) loquehacealhacertick(millisUntilFinished / 1000)
        }

        override fun onFinish() {
            counterState = false
        }
    }

    fun toggle() {
        Log.i("dam2", "toggle: $counterState")
        if (this.counterState){
            this.cancel()

        } else {
            Log.i("dam2", "toggle: start")
            this.start()
        }
    }

    fun start() {
        counterState = true
        this.myCounter.start()
    }

    fun cancel() {
        counterState = false
        this.myCounter.cancel()
    }
}