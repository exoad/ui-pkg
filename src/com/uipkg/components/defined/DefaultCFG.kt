package com.uipkg.components.defined

import com.uipkg.components.Configurator
import com.uipkg.components.defined.ClientMachine.clientScreenSpace

object DefaultCFG {
    val DEFAULT_CFG_SMALL = Configurator(800, 800)
    val DEFAULT_CFG_MEDIUM = Configurator(1024, 768)
    val DEFAULT_CFG_LARGE = Configurator(1280, 1024)
    val CFG_480P = Configurator(640, 480)
    val CFG_720P = Configurator(1280, 720)
    val CFG_1080P = Configurator(1920, 1080)
    val CFG_2160P = Configurator(3840, 2160)
    val DEFAULT_FILL_CFG = Configurator(
        clientScreenSpace.getWidth().toInt(), clientScreenSpace.getHeight()
            .toInt()
    )
}