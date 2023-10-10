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
 * 用户订单信息
 *
 */
public class PayOrder implements IsSerializable, Serializable {
  // Unique identifier for the user

    // Needed to make the GWT Compiler happy
    public PayOrder() {
    }

    public String orderId;
    public String userId; //开通后回填
    public String phone;
    public int period;
    public String amount;
    public String method; //开通后回填
    public String status; //开通后回填
    public Date timestamp;
}
