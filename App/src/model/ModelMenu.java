/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author usER
 */
public class ModelMenu {
        public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public ModelMenu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    public ModelMenu() {
    }

    private String icon;
    private String name;
    private MenuType type;

    public Icon toIcon() {
        return new ImageIcon(getClass().getResource("/image/" + icon + ".png"));
    }

    public static enum MenuType {
        TITLE, MENU, EMPTY
    }
}
