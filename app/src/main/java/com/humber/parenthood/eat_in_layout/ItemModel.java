package com.humber.parenthood.eat_in_layout;

public class ItemModel {
    final String name;
    boolean favourite = false;
    boolean selected = false;


    public ItemModel(String name) {
        this.name = name;
    }

    //getters
    public String getName() {
        return this.name;
    }

// --Commented out by Inspection START (2023-07-11, 19:13):
//    public void setName(String name) {
//        this.name = name;
//    }
// --Commented out by Inspection STOP (2023-07-11, 19:13)

    public boolean getFavourite() {
        return this.favourite;
    }

    public void setFavourite(boolean b) {
        favourite = b;
    }

    public boolean getSelected() {
        return this.selected;
    }

    public void setSelected(boolean b) {
        selected = b;
    }


}
