package com.cci.reportWriter.classes;

import com.cci.reportWriter.reportWriter;

public class Student extends Worker {
    private String SchoolName;
    public Student(String Name, String Lastname, String SchoolName)
    {
        super.setName(Name);
        super.setLastname(Lastname);
        setSchoolName(SchoolName);
    }

    public String getSchoolName()
    {
        return SchoolName;
    }
    public void setSchoolName(String schoolName)
    {
        SchoolName = schoolName;
    }

    public String toString()
    {
        return super.getName() + " " + super.getLastname() + reportWriter.SautLigne + getSchoolName();
    }
}
