package com.jlibs.noob.app.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

// Wrapper class for API functions
public class Window {
    // Private diplay-related members
    private WPanel panel;
    private JFrame window;
    
    // Constructor
    public Window(int width, int height, String name) {
        // Panel initialization for looping and drawing
        panel = new WPanel(new Dimension(width, height));
        // Window initialization with given name and default properties
        window = new JFrame(name);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        // Link the window and panel
        window.add(panel);
        window.pack();
        // Reposition window after resizing so it stays at the center of the screen
        window.setLocationRelativeTo(null);
        // Finally, show the window
        window.setVisible(true);
    }

    // Utility input or output funtions, part of the API
    public boolean keyPressed(char key) {
        return panel.getKeys().keyPressed(key);
    }
    
    // Utility API information getters
    public int getWidth() {
        return window.getWidth();
    }
    public int getHeight() {
        return window.getHeight();
    }
    public String getName() {
        return window.getTitle();
    }

    // Private classes, not accesible to the API user, and not needed by other classes
    // Private Panel class, not accesible by users of API
    private class WPanel extends JPanel {
        // KeyListener object, for key input
        private Keys keyEvents;
        
        // Constructor, initializing members and this object's values
        WPanel(Dimension size) {
            keyEvents = new Keys();
            this.setPreferredSize(size);
            this.setBackground(Color.BLACK);
            this.setDoubleBuffered(true);
            this.addKeyListener(keyEvents);
        }

        // Function for linking key input recieved by the panel with the Window utility functions
        public Keys getKeys() {
            return keyEvents;
        }
    }
    // KeyListener class, used for key input listening
    private class Keys implements KeyListener {
        private HashMap<Character, Boolean> keysPressed;

        public Keys() {
            keysPressed = new HashMap<>();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            keysPressed.put(e.getKeyChar(), true);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            keysPressed.put(e.getKeyChar(), false);
        }

        @Override
        public void keyTyped(KeyEvent e) {}
        
        public boolean keyPressed(char key) {
            try {
                return keysPressed.get(key);
            } catch (Exception e) {
                return false;
            }
        }
    }
}
