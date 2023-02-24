package com.humber.parenthood.eat_in_layout.eat_in_layout;

public class ItemModel {
    String name, src;
    boolean favourite = false;

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSrc() {
        return this.src;
    }

    public void serSrc(String src) {
        this.src = src;
    }

    public Boolean getFavourite(){
        return this.favourite;
    }
    public void setFavourite(boolean result){
        this.favourite = result;
    }

    public ItemModel(String name) {
        this.name = name;
    }

    private void findSrcImage(String item_name) {
        //search a repository for the item

    }

}
