package com.zalego2018dec.exercise.objects;

/**
 * Created by folio on 12/13/2018.
 */

public class DashboardItem {
    private int icon;
    private String text;

    public int getIcon() {
        return icon;
    }

    public DashboardItem(int icon, String text) {
        this.icon = icon;
        this.text = text;
    }

    public DashboardItem() {
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
