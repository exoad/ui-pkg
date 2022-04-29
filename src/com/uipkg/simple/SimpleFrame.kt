package com.uipkg.simple

import com.uipkg.exceptions.NonApplicableException
import kotlin.Throws
import java.lang.Runnable
import javax.swing.JFrame

interface SimpleFrame {
    fun run()

    @Throws(NonApplicableException::class)
    fun runWithTask(s: Runnable?)

    @Throws(NonApplicableException::class)
    fun killTask()
    val instanceFrame: JFrame?
}