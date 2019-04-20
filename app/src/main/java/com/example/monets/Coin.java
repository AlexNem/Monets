package com.example.monets;

import android.graphics.drawable.Drawable;

public class Coin {

    public int btn_id;
    public int image;
    public Integer price;

    public Coin(int btn_id, int image, int price) {
        this.btn_id = btn_id;
        this.image = image;
        this.price = price;
    }

    public int getBtn_id() {
        return btn_id;
    }

    public void setBtn_id(int btn_id) {
        this.btn_id = btn_id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
