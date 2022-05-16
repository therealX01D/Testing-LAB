package org.coffee;

public class timer {
    int time;
    public void setTimer(int intime){
        this.time = intime;
    }
    public void startHeater(int temp){
        heater ht= new heater();
        while(this.time!=0){
            ht.setTemp(temp);
            this.time--;
        }
    }
}
