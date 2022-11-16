package com.cci.reportWriter.classes;

import com.cci.reportWriter.reportWriter;

public class Glaces extends Worker {
    private String parfum;
    private float prix;
    public Glaces(String parfum, float prix)
    {
        this.parfum = parfum;
        this.prix = prix;
    }

    public String getParfum()
    {
        return parfum;
    }
    public void setParfum(String parfum)
    {
        this.parfum = parfum;
    }
    public float getPrix()
    {
        return prix;
    }
    public void setPrix(float prix)
    {
        this.prix = prix;
    }

    public String toString()
    {
        return "Glace " + parfum + reportWriter.SautLigne + "Prix : " + prix + "€";
    }
}
