package com.example.nhomcuong.applockv3.model;

/**
 * Created by sev_user on 8/3/2017.
 */

import android.graphics.drawable.Drawable;

/**
 * Created by sev_user on 8/2/2017.
 */

public class Item {
    private String label;
    private String packetName;
    private Drawable icon;
    private boolean ischecked;




    public Item(String label, String packetName, Drawable icon, boolean ischecked) {
        this.ischecked=ischecked;

        this.label = label;
        this.packetName = packetName;
        this.icon = icon;
    }
    public String getLabel() {
        return label;
    }

    public String getPacketName() {
        return packetName;
    }

    public Drawable getIcon() {
        return icon;
    }


    public void setLabel(String label) {
        this.label = label;
    }

    public void setPacketName(String packetName) {
        this.packetName = packetName;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }

    public boolean getischecked() {
        return ischecked;
    }

    public Item(){

    }
}
