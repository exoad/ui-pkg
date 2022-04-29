package com.uipkg.components

import com.uipkg.components.defined.ClientMachine
import java.awt.Color
import java.awt.Dimension
import javax.swing.ImageIcon

class Configurator(width: Int, height: Int) {
    val dimension: Dimension
    var backgroundColor = Color.WHITE
        private set
    var foregroundColor = Color.BLACK
        private set
    var titleStr = ""
        private set
    var listenerConfigurator: ListenerConfigurator? = null
        private set
    var icon: ImageIcon? = null
        private set

    constructor(title: String, width: Int, height: Int, background: Color) : this(width, height) {
        backgroundColor = background
        titleStr = title
    }

    constructor(
        title: String,
        width: Int,
        height: Int,
        background: Color,
        foreground: Color,
        icon: ImageIcon?,
        listenerConfigurator: ListenerConfigurator?
    ) : this(title, width, height, background) {
        foregroundColor = foreground
        titleStr = title
        this.icon = icon
        this.listenerConfigurator = listenerConfigurator
    }

    init {
        dimension = Dimension(width, height)
        titleStr = ClientMachine.clientName
    }
}