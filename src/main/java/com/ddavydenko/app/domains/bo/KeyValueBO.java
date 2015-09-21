package com.ddavydenko.app.domains.bo;


public class KeyValueBO {

    private String engWord;
    private String rusWord;

    public String getEngWord() {
        return engWord;
    }
    public void setEngWord(String engWord) {
        this.engWord = engWord;
    }
    public String getRusWord() {
        return rusWord;
    }
    public void setRusWord(String rusWord) {
        this.rusWord = rusWord;
    }

    @Override
    public String toString() {
        return "Hi frands!";

    }
}
