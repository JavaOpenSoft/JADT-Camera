/*
 * Created by JFormDesigner on Tue Oct 04 13:29:39 IST 2022
 */

package jadt.camera.guitemplate;

import com.github.sarxos.webcam.Webcam;

import javax.swing.*;
import java.awt.*;

/**
 * @author Rishon
 */
public class CameraViewport extends JPanel {

    public CameraViewport() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        viewport = new JLabel();

        //======== this ========
        setLayout(null);
        add(viewport);
        viewport.setBounds(0, 0, 400, 295);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel viewport;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
