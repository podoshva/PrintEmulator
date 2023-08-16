package com.company;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Main {
    public static void printEmulator() throws IOException, UnsupportedFlavorException, InterruptedException {
        Clipboard myClipboard = Toolkit.getDefaultToolkit().getSystemClipboard(); // paste something to clipboard
        DataFlavor dataFlavor = DataFlavor.stringFlavor; // get something from clipboard
        String message = myClipboard.getData(dataFlavor).toString();
        String[] chars = message.split("");

        for (int i = 0; i < chars.length; i++) {
            int time = (int) ((Math.random() + 0.7) * 100);
            Thread.sleep(time);
            StringSelection stringSelection = new StringSelection(chars[i]);
            myClipboard.setContents(stringSelection, null);
            try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_V);
                if (i == chars.length - 1) {
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                }
            } catch (AWTException ignored) {}
        }
        Thread.sleep(100);
        StringSelection stringSelection = new StringSelection(message);
        myClipboard.setContents(stringSelection, null);
    }

    public static void Timer() throws InterruptedException {
        for (int i = 5; i > 0; i--) {
            System.out.println("Работа начнется через " + i + " сек.");
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) throws IOException, UnsupportedFlavorException, InterruptedException {
        Timer();
        printEmulator();
    }
}