package org.example;
import org.jetbrains.annotations.NotNull;
public class statesofclock {
    private states currstate;
    private innerstates currinnerstate;
    private int m,h,D,M,Y;
    enum states {
        NORMAL,
        UPDATE,
        ALARM,
        UNDEF
    }
    enum innerstates {
        TIME,
        DATE,
        ALARM,
        MINUTE,
        HOUR,
        DAY,
        MONTH,
        YEAR,
        CHIME,
        UNDEF
    }
    statesofclock(){
        this.currstate=states.NORMAL;
        this.currinnerstate=innerstates.TIME;
        this.m=0;
        this.h=0;
        this.D=1;
        this.M=1;
        this.Y=2000;
    }
    public void inputhandle(char x){
        switch(this.currstate){
            case NORMAL:
                if (x =='c') {
                    this.currstate=states.UPDATE;
                    this.currinnerstate=innerstates.MINUTE;
                }
                if (x =='b') {
                    this.currstate = states.ALARM;
                    this.currinnerstate=innerstates.ALARM;
                }
                if (x =='a'){
                    if (this.currinnerstate==innerstates.TIME)
                            this.currinnerstate=innerstates.DATE;
                        else
                            this.currinnerstate=innerstates.TIME;
                }
                if(x == 'd'){
                    this.currstate=states.UNDEF;
                    this.currinnerstate=innerstates.UNDEF;
                }

                break;
            case UPDATE:
                if(x == 'c'){
                    this.currstate=states.UNDEF;
                    this.currinnerstate=innerstates.UNDEF;
                }
              //  if (x =='c') {
               //
               // } possible error undefined state conversion
                if (x =='b') {
                    if(this.currinnerstate==innerstates.MINUTE){
                        this.m++;
                        if(this.m>=59){
                            this.m=0;
                            this.h++;
                            if(this.h>=24){
                                this.h=0;
                                this.D++;
                                if(this.D>=31){
                                    this.D=0;
                                    this.M++;
                                    if(this.M>=12){
                                        this.M=0;
                                        this.Y++;
                                        if(this.Y>=2099){
                                            this.m=0;
                                            this.h=0;
                                            this.D=1;
                                            this.M=1;
                                            this.Y=2000;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(this.currinnerstate==innerstates.HOUR) {
                        this.h++;
                        if(this.h>=24){
                            this.h=0;
                            this.D++;
                            if(this.D>=31){
                                this.D=0;
                                this.M++;
                                if(this.M>=12){
                                    this.M=0;
                                    this.Y++;
                                    if(this.Y>=2099){
                                        this.m=0;
                                        this.h=0;
                                        this.D=1;
                                        this.M=1;
                                        this.Y=2000;
                                    }
                                }
                            }
                        }
                    }
                    if(this.currinnerstate==innerstates.DAY) {
                        this.D++;
                        if(this.D>=31){
                            this.D=0;
                            this.M++;
                            if(this.M>=12){
                                this.M=0;
                                this.Y++;
                                if(this.Y>=2099){
                                    this.m=0;
                                    this.h=0;
                                    this.D=1;
                                    this.M=1;
                                    this.Y=2000;
                                }
                            }
                        }
                    }
                    if(this.currinnerstate==innerstates.MONTH) {
                        this.M++;
                        if(this.M>=12){
                            this.M=0;
                            this.Y++;
                            if(this.Y>=2099){
                                this.m=0;
                                this.h=0;
                                this.D=1;
                                this.M=1;
                                this.Y=2000;
                            }
                        }
                    }
                    if(this.currinnerstate==innerstates.YEAR) {
                        this.Y++;
                        if(this.Y>=2099){
                            this.m=0;
                            this.h=0;
                            this.D=1;
                            this.M=1;
                            this.Y=2000;
                        }
                    }
                }
                if (x =='d') this.currstate=states.NORMAL;
                if (x =='a'){
                    if(this.currinnerstate==innerstates.MINUTE) this.currinnerstate=innerstates.HOUR;
                    else if(this.currinnerstate==innerstates.HOUR) this.currinnerstate=innerstates.DAY;
                    else if(this.currinnerstate==innerstates.DAY) this.currinnerstate=innerstates.MONTH;
                    else if(this.currinnerstate==innerstates.MONTH) this.currinnerstate=innerstates.YEAR;
                    else if(this.currinnerstate==innerstates.YEAR) this.currstate=states.NORMAL;
                }
                break;
            case ALARM:
                if(x=='a') this.currinnerstate=innerstates.CHIME;
                if(x=='d') this.currstate= states.NORMAL;
                if(x=='b'||x=='c'){
                    this.currstate=states.UNDEF;
                    this.currinnerstate=innerstates.UNDEF;
                }
                break;
            default:
                break;
        }
    }
    public void inputs( String xs){
        for (int i =0; i<xs.length();i++){
            this.inputhandle(xs.charAt(i));
        }
    }
    public  void DisplayDate() {System.out.println(this.Y+"-"+this.M+"-"+this.D);}
    public  void DisplayTIME() {System.out.println(this.h+":"+this.m);}
}