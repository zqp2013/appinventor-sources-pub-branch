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
 * aia商店信息
 *
 */
public class AiaStore implements IsSerializable, Serializable {
  // Unique identifier for the user

    // Needed to make the GWT Compiler happy
    public AiaStore() {
    }

    public String getAsId(){return asId;}
    public String getTitle(){return title;}
    public String getPhone(){return phone;}
    public String getAia_path(){return aia_path;}
    public String getPics(){return pics;}
    public String getContents(){return contents;}
    public String getPrice(){return price;}
    public String getApp_status(){return app_status;}
    public String getRanking(){return ranking;}
    public int getNum_screen(){return num_screen;}
    public int getNum_blocks(){return num_blocks;}
    public String getCatalog(){return catalog;}
    public String getQuality(){return quality;}
    public String getScore(){return score;}
    public Date getPublish_time(){return publish_time;}

    public String asId;
    public String title;
    public String phone;
    public String aia_path;
    public String pics;
    public String contents;
    public String price;
    public String app_status;//审核状态
    public String ranking;//综合排名
    public int num_screen;
    public int num_blocks;
    public String catalog;//aia分类
    public String quality;//质量等级
    public String score;//最新评分
    public Date publish_time;
}
