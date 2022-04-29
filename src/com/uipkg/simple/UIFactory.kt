package com.uipkg.simple

import com.uipkg.components.Configurator
import com.uipkg.components.defined.DefaultCFG
import com.uipkg.exceptions.NonApplicableException
import java.awt.event.*
import javax.swing.JComponent
import javax.swing.JFrame
import kotlin.Throws
import java.lang.Runnable
import javax.swing.WindowConstants

class UIFactory(cfg: Configurator, vararg components: JComponent?) : JFrame(), SimpleFrame {
    constructor() : this(DefaultCFG.CFG_480P) {}
    constructor(vararg components: JComponent?) : this(DefaultCFG.CFG_480P, *components) {}

    override fun run() {
        pack()
        isVisible = true
    }

    @Throws(NonApplicableException::class)
    override fun runWithTask(s: Runnable) {
        throw NonApplicableException("UIFactory frames cannot be attached with a synchronous task.")
    }

    @Throws(NonApplicableException::class)
    override fun killTask() {
        throw NonApplicableException("UIFactory frames cannot be attached with a synchronous task.")
    }

    override fun getInstanceFrame(): JFrame {
        return this
    }

    companion object {
        private const val serialVersionUID = 1L
    }

    init {
        preferredSize = cfg.dimension
        background = cfg.backgroundColor
        foreground = cfg.foregroundColor
        defaultCloseOperation = DISPOSE_ON_CLOSE
        title = cfg.titleStr
        if (cfg.icon != null) {
            iconImage = cfg.icon.image
        }
        for (component in components) {
            add(component)
        }
        val listeners = cfg.listenerConfigurator.listeners
        for (listener in listeners) {
            if (listener is WindowListener) {
                addWindowListener(listener as WindowListener)
            } else if (listener is KeyListener) {
                addKeyListener(listener as KeyListener)
            } else if (listener is FocusListener) {
                addFocusListener(listener as FocusListener)
            } else if (listener is MouseListener) {
                addMouseListener(listener as MouseListener)
            } else if (listener is MouseMotionListener) {
                addMouseMotionListener(listener as MouseMotionListener)
            } else if (listener is MouseWheelListener) {
                addMouseWheelListener(listener as MouseWheelListener)
            } else if (listener is ComponentListener) {
                addComponentListener(listener as ComponentListener)
            } else {
                try {
                    throw NonApplicableException("Listener type not supported")
                } catch (e: NonApplicableException) {
                    e.printStackTrace()
                }
            }
        }
    }
}