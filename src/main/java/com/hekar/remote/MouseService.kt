package com.hekar.remote

import org.springframework.stereotype.Component

import java.awt.*
import java.awt.event.InputEvent
import java.awt.event.KeyEvent

@Component
class MouseService {

    fun move(x: Int, y: Int): String {
        val location = MouseInfo.getPointerInfo().location
        val robot = getRobotInstance()
        robot.mouseMove(location.x + x, location.y + y)
        return "success"
    }

    fun scroll(y: Int): String {
        val robot = getRobotInstance()
        robot.mouseWheel(y)
        return "success"
    }

    fun click(): String {
        val robot = getRobotInstance()
        robot.mousePress(InputEvent.BUTTON1_MASK)
        robot.delay(100)
        robot.mouseRelease(InputEvent.BUTTON1_MASK)
        return "success"
    }

    fun rightClick(): String {
        val robot = getRobotInstance()
        robot.mousePress(InputEvent.BUTTON3_MASK)
        robot.delay(100)
        robot.mouseRelease(InputEvent.BUTTON3_MASK)
        return "success"
    }

    fun keyPress(key: Char): String {
        val robot = getRobotInstance()
        robot.keyPress(key.toInt())
        robot.delay(200)
        robot.keyRelease(key.toInt())
        return "success"
    }

    companion object {
        private var robotInstance: Robot? = null
    }

    private fun getRobotInstance(): Robot {
        robotInstance = robotInstance ?: Robot()
        return robotInstance!!
    }
}
