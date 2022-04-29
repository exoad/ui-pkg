package com.uipkg.components.defined

import java.awt.Dimension
import java.awt.Toolkit

object ClientMachine {
    @JvmStatic
    val clientScreenSpace: Dimension
        get() = Toolkit.getDefaultToolkit().screenSize
    val clientName: String
        get() = System.getProperty("os.name")
}