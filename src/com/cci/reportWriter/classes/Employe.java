package com.cci.reportWriter.classes;

import com.cci.reportWriter.reportWriter;

public class Employe extends Worker {
    public Employe(String Name, String Lastname, int Taux, int Conges)
    {
        super.setName(Name);
        super.setLastname(Lastname);
        super.setTaux(Taux);
        super.setConges(Conges);
    }

    public String toString()
    {
        return super.getName() + " " + super.getLastname() +
                reportWriter.SautLigne +
                super.getTaux() + "€ / Month, " + super.getConges() + " Days left.";
    }
}
