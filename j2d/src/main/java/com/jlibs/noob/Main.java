package com.jlibs.noob;

/*
 * Testing class, not part of the API
 */

import com.jlibs.noob.app.core.Window;

public class Main {
    public static void main(String[] args) {
        Window window1 = new Window(800, 600, "Window");
        System.out.println("width: " + window1.getWidth());
        System.out.println("height: " + window1.getHeight());
        System.out.println("name: " + window1.getName());
    }
}