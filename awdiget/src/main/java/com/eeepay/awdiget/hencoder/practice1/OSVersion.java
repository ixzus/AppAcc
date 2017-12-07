package com.eeepay.awdiget.hencoder.practice1;

/**
 * Created by huan on 2017/12/7.
 */

public class OSVersion {
    private String name;
    private float number;
    private int color;

    public OSVersion(String name, float number, int color) {
        this.name = name;
        this.number = number;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public float getNumber() {
        return number;
    }

    public int getColor() {
        return color;
    }
}
