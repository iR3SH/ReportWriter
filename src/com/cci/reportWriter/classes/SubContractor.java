package com.cci.reportWriter.classes;

import com.cci.reportWriter.reportWriter;

public class SubContractor extends Worker {
    public SubContractor(String Name, String Lastname, int Taux)
    {
        super.setName(Name);
        super.setLastname(Lastname);
        super.setTaux(Taux);
    }

    public String getDailyRate()
    {
        double taux = (double)super.getTaux() / 30;
        if(taux >= 1)
        {
            return super.getTaux() / 30+ "€ / Day";
        }
        else {
            return taux + "€ / Day";
        }
    }

    public String toString()
    {
        return super.getName() + " " + super.getLastname() + reportWriter.SautLigne + getDailyRate();
    }
}
