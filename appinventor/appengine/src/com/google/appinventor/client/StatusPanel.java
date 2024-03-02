// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.client;

import static com.google.appinventor.client.Ode.MESSAGES;

import com.google.common.base.Strings;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Frame;
import java.util.Date;

/**
 * The status panel contains various links.
 *
 */
public class StatusPanel extends Composite {

  interface StatusPanelUiBinder extends UiBinder<FlowPanel, StatusPanel> {}
  private static final StatusPanelUiBinder UI_BINDER = GWT.create(StatusPanelUiBinder.class);

  @UiField(provided = true) FlowPanel footer = new FlowPanel("footer");
  @UiField LIElement classic;
  @UiField LIElement lightgreen;
  @UiField LIElement blue;
  @UiField LIElement red;
  @UiField LIElement gray;
  @UiField LIElement pink;
  @UiField LIElement orange;

  @UiField HTML switchDark;
  @UiField Anchor tosLink;
  @UiField Frame searchFrame;

  /**
   * Initializes and assembles all UI elements shown in the status panel.
   */
  public StatusPanel() {
    initWidget(UI_BINDER.createAndBindUi(this));

    String tosUrl = Ode.getSystemConfig().getTosUrl();
    if (!Strings.isNullOrEmpty(tosUrl)) {
      tosLink.setHref(tosUrl);
    } else {
      tosLink.removeFromParent();
    }
    searchFrame.setUrl("https://www.fun123.cn/reference/info/search/?" + (new Date()).getTime());

    //Add by 中文网
    switchDark.addStyleName("switchDark");
    if (Ode.getUserDarkThemeEnabled()) {
      switchDark.setHTML("<i class=\"mdi mdi-weather-sunny\" style=\"font-size:15px\" title=\"切换到白天模式\"></i>");
      switchDark.addClickListener(new ClickListener() {
        public void onClick(Widget sender) {
          Ode.setUserDarkThemeEnabled(false);
        }
      });
    } else {
      switchDark.setHTML("<i class=\"mdi mdi-weather-night\" style=\"font-size:15px\" title=\"切换到黑夜模式\"></i>");
      switchDark.addClickListener(new ClickListener() {
        public void onClick(Widget sender) {
          Ode.setUserDarkThemeEnabled(true);
        }
      });
    }

    String theme = Ode.getUserTheme();
    if ("classic".equals(theme)) {
      classic.addClassName("active");
    } else if ("lightgreen".equals(theme)) {
      lightgreen.addClassName("active");
    } else if ("blue".equals(theme)) {
      blue.addClassName("active");
    } else if ("red".equals(theme)) {
      red.addClassName("active");
    } else if ("gray".equals(theme)) {
      gray.addClassName("active");
    } else if ("pink".equals(theme)) {
      pink.addClassName("active");
    } else if ("orange".equals(theme)) {
      orange.addClassName("active");
    } else {
      classic.addClassName("active");//默认经典色
    }

    DOM.sinkEvents(classic, Event.ONCLICK);
    DOM.setEventListener(classic, new EventListener() {
      @Override
      public void onBrowserEvent(Event event) {
          if (Event.ONCLICK == event.getTypeInt()) { Ode.setUserTheme("classic"); }
      }
    });
    DOM.sinkEvents(lightgreen, Event.ONCLICK);
    DOM.setEventListener(lightgreen, new EventListener() {
      @Override
      public void onBrowserEvent(Event event) {
          if (Event.ONCLICK == event.getTypeInt()) { Ode.setUserTheme("lightgreen"); }
      }
    });
    DOM.sinkEvents(blue, Event.ONCLICK);
    DOM.setEventListener(blue, new EventListener() {
      @Override
      public void onBrowserEvent(Event event) {
          if (Event.ONCLICK == event.getTypeInt()) { Ode.setUserTheme("blue"); }
      }
    });
    DOM.sinkEvents(red, Event.ONCLICK);
    DOM.setEventListener(red, new EventListener() {
      @Override
      public void onBrowserEvent(Event event) {
          if (Event.ONCLICK == event.getTypeInt()) { Ode.setUserTheme("red"); }
      }
    });
    DOM.sinkEvents(gray, Event.ONCLICK);
    DOM.setEventListener(gray, new EventListener() {
      @Override
      public void onBrowserEvent(Event event) {
          if (Event.ONCLICK == event.getTypeInt()) { Ode.setUserTheme("gray"); }
      }
    });
    DOM.sinkEvents(pink, Event.ONCLICK);
    DOM.setEventListener(pink, new EventListener() {
      @Override
      public void onBrowserEvent(Event event) {
          if (Event.ONCLICK == event.getTypeInt()) { Ode.setUserTheme("pink"); }
      }
    });
    DOM.sinkEvents(orange, Event.ONCLICK);
    DOM.setEventListener(orange, new EventListener() {
      @Override
      public void onBrowserEvent(Event event) {
          if (Event.ONCLICK == event.getTypeInt()) { Ode.setUserTheme("orange"); }
      }
    });

  }

  @UiFactory
  public OdeMessages getMessages() {
    return MESSAGES;
  }
}
