package org.gilmour.gos.enums;

public enum ImageFormat {
    JPG(1, "jpg"), PNG(2, "png"), RAW(3, "img");
    private int key;
    private String value;

    private ImageFormat(int k, String v){
        this.key = k;
        this.value = v;
    }
}
