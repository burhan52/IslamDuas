package com.example.islamduas.model;

public class Dua {
    private int id;
    private String tital;
    private String dua;
    private String transliteration;
    private String translation;
    private String source;

    public Dua(int id, String tital, String dua, String transliteration, String translation, String source) {
        this.id = id;
        this.tital = tital;
        this.dua = dua;
        this.transliteration = transliteration;
        this.translation = translation;
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTital() {
        return tital;
    }

    public void setTital(String tital) {
        this.tital = tital;
    }

    public String getDua() {
        return dua;
    }

    public void setDua(String dua) {
        this.dua = dua;
    }

    public String getTransliteration() {
        return transliteration;
    }

    public void setTransliteration(String transliteration) {
        this.transliteration = transliteration;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
