package com.cci.reportWriter.classes;

import com.cci.reportWriter.reportWriter;

import java.util.ArrayList;

public class AnonymObject {
    private String title;
    private ArrayList<ArrayList<String>> data;

    public AnonymObject(String title, ArrayList<ArrayList<String>> data)
    {
        this.title = title;
        this.data = data;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
    public ArrayList<ArrayList<String>> getData()
    {
        return data;
    }
    public void setData(ArrayList<ArrayList<String>> data)
    {
        this.data = data;
    }
    public String getDailyRate(String data)
    {
        double taux = Double.parseDouble(data) / 30;
        if(taux >= 1)
        {
            return Integer.parseInt(data) / 30+ "€ / Day";
        }
        else {
            return taux + "€ / Day";
        }
    }

    public StringBuilder toStringBuilder()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(title).append(reportWriter.SautLigne);
        for (ArrayList<String> list : data) {
            builder.append(list.get(0)).append(" : ");
            switch (Integer.parseInt(list.get(1)))
            {
                case 1 -> {
                    builder.append(Integer.parseInt(list.get(2))).append("€ / Month");
                }
                case 2 -> {
                    builder.append(getDailyRate(list.get(2)));
                }
                case 3 -> {
                    builder.append(Integer.parseInt(list.get(2))).append("€");
                }
                case 4 -> {
                    builder.append(list.get(2));
                }
                case 5 -> {
                    builder.append(Integer.parseInt(list.get(2)));
                }
            }
            builder.append(reportWriter.SautLigne);
        }
        builder.append(reportWriter.SautLigne).append(reportWriter.SautLigne);
        return builder;
    }
}
