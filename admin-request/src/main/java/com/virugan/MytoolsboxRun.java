package com.virugan;


import com.virugan.myUtlis.myLogUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MytoolsboxRun  implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        //RunJFrame();
        System.err.println("MytoolsboxApplication is started !!!");
    }

/*    public static void RunJFrame() {
        Browser browser=new Browser();
        BrowserView view = new BrowserView(browser);
        JFrame frame = new JFrame("myToolsBox-2.0");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(view, BorderLayout.CENTER);
        //frame.setSize(2500, 1500);
        frame.setSize(1200, 700);
        //frame.setMinimumSize(new Dimension(1500, 875));
        frame.setMinimumSize(new Dimension(1200, 700));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        browser.loadURL("http://localhost:3392/index.html");
    }*/
}
