package com.uipkg.components

import java.awt.event.AWTEventListener
import java.util.ArrayList

class ListenerConfigurator(vararg listeners: AWTEventListener) {
    var listeners = ArrayList<AWTEventListener>()

    init {
        for (listener in listeners) {
            this.listeners.add(listener)
        }
    }
}