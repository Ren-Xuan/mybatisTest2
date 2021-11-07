package com.renxuan.mybatis.entity;

public enum SEX {
    /**
     * female.
     */
    FEMALE(0, "Ů"),
     /**
     * male.
     */
    MALE(1,"��"),
    /**
     * unknown.
     */
    UNKNOWN(2, "δ֪");

    private int value;
    private String description;

    SEX(int value, String description) {
        this.value = value;
        this.description = description;
    }
    
 
    public int value() {
        return this.value;
    }
    
 
    public String description() {
        return this.description;
    }
}