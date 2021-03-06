/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.window;

import com.gwtext.client.core.EventObject;

import java.util.Date;

import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

import com.gwtextux.client.widgets.window.ToastWindow;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

public class ToastWindowSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/window/ToastWindowSample.java.html";
    }

    public String getIntro() {
        return "<p>This is an MSN-style popup 'toast' notification window.</p>";
    }
    
    public Panel getViewPanel() {
        if (panel == null) {
        	panel = new Panel();
        	
        	Button button = new Button("Show");
        	button.setIconCls("wand-icon");
            button.addListener(new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    ToastWindow tw = new ToastWindow();
                    tw.setTitle("Message");
                    tw.setIconCls((Math.random() > 0.5) ? "information" : "exclamation");
                    tw.setMessage("Message generated on : " + new Date());
                    tw.show();
                }
            });

            panel.add(button);
        }
        return panel;
    }
}