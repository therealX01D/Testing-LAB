package org.example;

public class timechange {
    int m,h,D,M,Y;
    timechange(){
        this.m=0;
        this.h=0;
        this.D=1;
        this.M=1;
        this.Y=2000;
    }
    public void incminute(){
        this.m++;
        if(this.m>=59){
            this.m=0;
            this.inchour();
        }
    }
    public void inchour(){
        this.h++;
        if(this.h>=24){
            this.h=0;
            this.incday();
        }
    }
    public void incday(){
        this.D++;
        if(this.D>=31){
            this.D=1;
            this.incmonth();
        }
    }
    public void incmonth(){
        this.M++;
        if(this.M>=12){
            this.M=1;
            this.incyear();
        }
    }
    public void incyear(){
        this.Y++;
        if(this.Y>=2099){
            this.m=0;
            this.h=0;
            this.D=1;
            this.M=1;
            this.Y=2000;
        }
    }
    public  String returnDate() {return this.Y+"-"+this.M+"-"+this.D;}
    public  String returnTIME() {return this.h+":"+this.m;}
}

