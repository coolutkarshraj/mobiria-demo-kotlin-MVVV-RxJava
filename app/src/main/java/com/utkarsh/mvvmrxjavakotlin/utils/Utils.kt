package com.utkarsh.mvvmrxjavakotlin.utils

import android.text.TextUtils
import android.util.Patterns
import java.util.concurrent.TimeUnit


class Utils {
    /*
    this class give days,hours,min sec if you provide time stamp in sec
    * */
    companion object {
        /*
    For Email Verification we use this
    */
        fun isValidEmail(target: CharSequence?): Boolean {
            return if (TextUtils.isEmpty(target)) {
                false
            } else {
                Patterns.EMAIL_ADDRESS.matcher(target).matches()
            }
        }
        /*
         * Method TO Calculate remaining day from time stamp given in sec
         * */
        fun calculateDay(seconds: Long): Long {
            val day = TimeUnit.SECONDS.toDays(seconds) as Long
            return day
        }

        /*
       * Method TO Calculateremaining  Hour from time stamp given in sec
       * */
        fun calculateHours(seconds: Long): Long {
            val day = TimeUnit.SECONDS.toDays(seconds) as Long
            val hours: Long = TimeUnit.SECONDS.toHours(seconds) - day * 24
            return hours;
        }

        /*
         * Method TO Calculate remaining Minute from time stamp given in sec
         * */

        fun calculateMin(seconds: Long): Long {
            val minute: Long =
                TimeUnit.SECONDS.toMinutes(seconds) - TimeUnit.SECONDS.toHours(seconds) * 60
            return minute;
        }

        /*
        * Method TO Calculate remaining Second from time stamp given in sec
        * */
        fun calculateSec(seconds: Long): Long {
            val day = TimeUnit.SECONDS.toDays(seconds).toInt()
            val hours = TimeUnit.SECONDS.toHours(seconds) - day * 24
            val minute =
                TimeUnit.SECONDS.toMinutes(seconds) - TimeUnit.SECONDS.toHours(seconds) * 60
            val second =
                TimeUnit.SECONDS.toSeconds(seconds) - TimeUnit.SECONDS.toMinutes(seconds) * 60
           return second;
        }
    }
}