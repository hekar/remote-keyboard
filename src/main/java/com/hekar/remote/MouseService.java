package com.hekar.remote;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

@Component
public class MouseService {

    private static Robot robotInstance;

    private static Robot getRobotInstance() {
        if (robotInstance == null) {
            try {
                robotInstance = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }

        return robotInstance;
    }

    public String move(int x, int y) {
        final Point location = MouseInfo.getPointerInfo().getLocation();
        final Robot robot = getRobotInstance();
        robot.mouseMove(location.x + x, location.y + y);
        return "success";
    }

    public String scroll(int y) {
        final Robot robot = getRobotInstance();
        robot.mouseWheel(y);
        return "success";
    }

    public String click() {
        final Robot robot = getRobotInstance();
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(100);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        return "success";
    }

    public String rightClick() {
        final Robot robot = getRobotInstance();
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.delay(100);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        return "success";
    }

    @NotNull
    public String keyPress(char key) {
        final Robot robot = getRobotInstance();
        robot.keyPress(key);
        robot.delay(200);
        robot.keyRelease(key);
        return "success";
    }
}
