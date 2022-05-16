package org.example;

public class watchstates {
        private states currstate;
        private innerstates currinnerstate;
        private timechange tm;
        public enum states {
            NORMAL,
            UPDATE,
            ALARM,
            UNDEF
        }
        public enum innerstates {
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
        watchstates(){
            this.currstate=states.NORMAL;
            this.currinnerstate=innerstates.TIME;
            this.tm=new timechange();
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
                            tm.incminute();
                        }
                        if(this.currinnerstate==innerstates.HOUR) {
                            tm.inchour();
                        }
                        if(this.currinnerstate==innerstates.DAY) {
                            tm.incday();
                        }
                        if(this.currinnerstate==innerstates.MONTH) {
                            tm.incmonth();
                        }
                        if(this.currinnerstate==innerstates.YEAR) {
                            tm.incyear();
                        }
                    }
                    if (x =='d') {
                        this.currstate = states.NORMAL;
                        this.currinnerstate=innerstates.TIME;
                    }
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

    public states getCurrstate() {
        return currstate;
    }

    public innerstates getCurrinnerstate() {
        return currinnerstate;
    }

    public  void displayDate() {System.out.println(tm.returnDate());}
        public  void displayTime() {System.out.println(tm.returnTIME());}
}
