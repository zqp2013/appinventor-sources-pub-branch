// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.shared.rpc.user;

import com.google.gwt.user.client.rpc.IsSerializable;
import java.io.Serializable;
import java.util.Date;

/**
 * aia商店购买信息
 *
 */
public class AiaBuy implements IsSerializable, Serializable {
  // Unique identifier for the user

    // Needed to make the GWT Compiler happy
    public AiaBuy() {
    }

    public Long getId(){return id;}
    public String getAsId(){return asId;}
    public String getOwner_phone(){return owner_phone;}
    public String getBuy_phone(){return buy_phone;}
    public String getPrice(){return price;}
    public String getCommission(){return commission;}
    public Date getBuy_time(){return buy_time;}

    public Long id;
    public String asId;
    public String owner_phone; //发布者
    public String buy_phone; //购买者
    public String price;
    public String commission;//佣金
    public Date buy_time;
}
