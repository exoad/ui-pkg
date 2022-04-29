package com.uipkg.simple

import com.uipkg.exceptions.NonApplicableException
import kotlin.Throws
import java.lang.Runnable
import javax.swing.JFrame

class SplashScreen(private val timeMS: Float) : SimpleFrame {
    override fun run() {}
    @Throws(NonApplicableException::class)
    override fun runWithTask(s: Runnable) {
    }

    @Throws(NonApplicableException::class)
    override fun killTask() {
    }

    override fun getInstanceFrame(): JFrame {
        return null
    }
}