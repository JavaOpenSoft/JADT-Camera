package jadt.camera;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CameraViewport {

    private Camera camera;
    private JPanel viewportFrame;
    private JLabel viewport;
    public CameraViewport(){
        this.viewport = new JLabel();
        this.viewportFrame = new JPanel();
    }
    public JPanel getViewport(){
        return viewportFrame;
    }
    public void add(Camera camera){
        this.camera = camera;
    }
    public void init(){
        viewport.setBounds(0,0,400,400);
        viewportFrame.add(viewport);
        viewportFrame.setSize(400,600);
        while(viewportFrame.isEnabled()){
            viewport.setIcon(new ImageIcon(camera.getComponent().getImage()));
        }
    }
    public Camera getCamera(){
        return camera;
    }
}