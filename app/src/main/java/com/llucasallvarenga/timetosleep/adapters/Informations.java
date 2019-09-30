package com.llucasallvarenga.timetosleep.adapters;

public class Informations {

    private int icons;
    private String titlesSections;

    public Informations(int icons, String titlesSections) {
        this.icons = icons;
        this.titlesSections = titlesSections;
    }

    public int getIcons() {
        return icons;
    }

    public void setIcons(int icons) {
        this.icons = icons;
    }

    public String getTitlesSections() {
        return titlesSections;
    }

    public void setTitlesSections(String titlesSections) {
        this.titlesSections = titlesSections;
    }
}
