package com.virugan.mytoolsbox;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.events.*;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import com.virugan.mytoolsbox.configuration.myContents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MytoolsboxRun  implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        //RunJFrame();

        myContents.log("MyToolsBox is started finished !!!");
    }

    public static void RunJFrame() {
        Browser browser=new Browser();
        BrowserView view = new BrowserView(browser);
        JFrame frame = new JFrame("myToolsBox v1.0");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(view, BorderLayout.CENTER);
        //frame.setSize(2500, 1500);
        frame.setSize(1200, 700);
        //frame.setMinimumSize(new Dimension(1500, 875));
        frame.setMinimumSize(new Dimension(1200, 700));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        browser.addLoadListener(new LoadAdapter() {
            public void onFinishLoadingFrame(FinishLoadingEvent event) {
            }
            public void onProvisionalLoadingFrame(ProvisionalLoadingEvent event) {
            }
        });
        browser.addScriptContextListener(new ScriptContextListener() {
            public void onScriptContextDestroyed(ScriptContextEvent event) {
            }
            public void onScriptContextCreated(ScriptContextEvent arg0) {
            }
        } );
        browser.loadURL("http://localhost:8080/index.html");
    }
}
