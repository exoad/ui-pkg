package com.uipkg.simple

import com.uipkg.components.defined.ClientMachine
import java.awt.*
import java.awt.geom.AffineTransform
import javax.swing.JPanel
import javax.swing.JFrame
import javax.swing.JLabel
import java.lang.Runnable
import java.lang.InterruptedException
import kotlin.jvm.Synchronized

class LoadingWindow : JPanel {
    private var lastRotation = 0.0111111
    private var dualAxisOther = -0.03
    private var decFirst: Double
    private var decSecond: Double
    private val jf: JFrame
    private var fg: Color
    private var bg: Color

    @Transient
    private var worker: Thread? = null

    constructor(
        foreground: Color?, background: Color?, text: String?, refreshRate: Long, firstRotSpeed: Double,
        secondRotSpeed: Double, decrementSpeedFirst: Double, decrementSpeedSecond: Double, isCenter: Boolean
    ) {
        jf = JFrame()
        jf.title = text
        jf.isUndecorated = true
        jf.preferredSize = Dimension(500, 300)
        jf.isResizable = false
        jf.isLocationByPlatform = true
        jf.layout = BorderLayout()
        if (isCenter) {
            val screenSpace = ClientMachine.clientScreenSpace
            jf.setLocation(screenSpace.width / 2 - 300, screenSpace.height / 2)
        }
        val jl = JLabel(text)
        jl.foreground = foreground ?: Color(56, 56, 56)
        jl.alignmentX = RIGHT_ALIGNMENT
        jl.alignmentY = CENTER_ALIGNMENT
        jl.font = jl.font.deriveFont(30f)
        jf.contentPane.add(this)
        jf.add(jl, BorderLayout.EAST)
        Thread {
            while (true) {
                repaint()
                try {
                    Thread.sleep(refreshRate)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }.start()
        fg = foreground ?: Color(56, 56, 56)
        bg = background ?: Color(247, 170, 69)
        lastRotation = firstRotSpeed
        dualAxisOther = secondRotSpeed
        decFirst = decrementSpeedFirst
        decSecond = decrementSpeedSecond
    }

    constructor() {
        jf = JFrame()
        jf.title = "Loading..."
        jf.preferredSize = Dimension(500, 300)
        jf.isResizable = false
        jf.isLocationByPlatform = true
        jf.isUndecorated = true
        val screenSpace = ClientMachine.clientScreenSpace
        jf.setLocation(screenSpace.width / 2 - 300, screenSpace.height / 2 - 100)
        jf.layout = BorderLayout()
        val jl = JLabel("Loading...     ")
        jl.foreground = Color(56, 56, 56)
        jl.alignmentX = RIGHT_ALIGNMENT
        jl.alignmentY = CENTER_ALIGNMENT
        jl.font = jl.font.deriveFont(30f)
        jf.contentPane.add(this)
        jf.add(jl, BorderLayout.EAST)
        Thread {
            while (true) {
                repaint()
                try {
                    Thread.sleep(30)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }.start()
        decFirst = Math.PI
        decSecond = Math.PI
        fg = Color(56, 56, 56)
        bg = Color(247, 170, 69)
    }

    @Synchronized
    public override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        val g2 = g as Graphics2D
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
        val at = AffineTransform()
        val at2 = AffineTransform()
        val shape = Rectangle(-110, 40, 220, 220)
        val shapeWireframe = Rectangle(-110, 40, 230, 230)
        at.rotate(lastRotation, shape.getX() + shape.getWidth() / 2, shape.getY() + shape.getHeight() / 2)
        at2.rotate(
            dualAxisOther, shapeWireframe.getX() + shapeWireframe.getWidth() / 2,
            shapeWireframe.getY() + shapeWireframe.getHeight() / 2
        )
        dualAxisOther -= decFirst / 100
        lastRotation += decSecond / 150
        g2.color = bg
        val s = at.createTransformedShape(shape)
        g2.fill(s)
        g2.color = fg
        val s2Shape = at2.createTransformedShape(shapeWireframe)
        g2.stroke = BasicStroke(3)
        g2.draw(s2Shape)
    }

    @Synchronized
    fun start(r: Runnable?) {
        jf.pack()
        jf.isVisible = true
        worker = Thread(r)
        try {
            worker!!.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    @Synchronized
    fun start() {
        jf.pack()
        jf.isVisible = true
    }

    @Synchronized
    fun kill() {
        jf.dispose()
        if (worker != null) worker!!.interrupt()
    }
}