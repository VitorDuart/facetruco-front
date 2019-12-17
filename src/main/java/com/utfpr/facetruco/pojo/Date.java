package com.utfpr.facetruco.pojo;

import java.util.GregorianCalendar;
import java.util.List;

public class Date{
    private List<String> days;
    private List<String> months;
    private List<String> years;

    public Date(){
        

    }

    private List<String>addListDays(){
        GregorianCalendar g = new GregorianCalendar();
        
        return null;
    }

    public List<String> getDays() {return this.days;}
    public void setDays(List<String> days) {this.days = days;}
    public List<String> getMonths() {return this.months;}
    public void setMonths(List<String> months) {this.months = months;}
    public List<String> getYears() {return this.years;}
    public void setYears(List<String> years) {this.years = years;}

}