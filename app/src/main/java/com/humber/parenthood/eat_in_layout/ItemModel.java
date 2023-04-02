package com.humber.parenthood.eat_in_layout;

public class ItemModel {
    String name, src;
    boolean favourite = false;
    boolean selected = false;


    //getters
    public String getName() {
        return this.name;
    }
    public String getSrc() {
        return this.src;
    }
    public boolean getFavourite(){
        return this.favourite;
    }
    public boolean getSelected(){
        return this.selected;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSrc(String src) {
        this.src = src;
    }

    public void setFavourite(boolean b) {
        favourite= b;
    }
    public void setSelected(boolean b) {
        selected= b;
    }

    public ItemModel(String name) {
        this.name = name;
    }


    private void findSrcImage(String item_name) {
        //search a repository for the item

    }
}
