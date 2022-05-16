package org.coffee;

public class heater {
    int currtemp,MAXTEMP=1000;
    public int setTemp(int temp){
        if (temp>=MAXTEMP) return -1;
        if(currtemp>temp)
            while(currtemp!=temp) currtemp--;
        else {while(currtemp!=temp) currtemp++;}
        return currtemp;
    }
}
