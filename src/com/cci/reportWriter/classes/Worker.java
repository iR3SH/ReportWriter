package com.cci.reportWriter.classes;

public abstract class Worker {
    private String Name, Lastname;
    private int Taux, Conges;

    public String getName()
    {
        return Name;
    }
    public void setName(String name)
    {
        Name = name;
    }

    public String getLastname()
    {
        return Lastname;
    }
    public void setLastname(String lastname)
    {
        Lastname = lastname;
    }

    public int getTaux()
    {
        return Taux;
    }
    public void setTaux(int taux)
    {
        Taux = Math.max(taux, 0);
    }

    public int getConges()
    {
        return Conges;
    }
    public void setConges(int conges)
    {
        Conges = Math.max(conges, 0);
    }

    public abstract String toString();
}
