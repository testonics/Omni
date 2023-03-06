package org.testonics.omni.utils;

import java.awt.*;

public class MouseMover {
    private static final int SLEEP_MILLIS = 60*1000;

    public static void keepAliveByMouseMove() throws Exception {
        keepAliveByMouseMove(10);
    }

    public static void keepAliveByMouseMove(int timeoutInSeconds) throws Exception {
        Robot robot = new Robot();
        long currentTimeInMillis = System.currentTimeMillis();
        long timeout = currentTimeInMillis + (timeoutInSeconds * 1000L);
        while (System.currentTimeMillis() < timeout) {
            Point point = MouseInfo.getPointerInfo().getLocation();
            robot.mouseMove(point.x, point.y);
            System.out.println("Mouse Moved!!");
            Thread.sleep(SLEEP_MILLIS);
        }
    }
}