package org.coffee;

public class coffeemachine {
    String Type;
    int temperaturetomake;
    public void setType(String Type){
        this.Type=Type;
    }

    public int picktiming(){
        int time=0;
        switch(Type) {
            case "Black":
                   time=1000;
                   break;
            case "latte":
                   time=500;
                    break;
            default:
                    break;
        }
        return time;
    }
    public int picktemp(){
        int temp=0;
        switch(Type) {
            case "Black":
                temp=25;
                break;
            case "latte":
                temp=30;
                break;
            default:
                break;
        }
        return temp;
    }
    public void startmaking(){
        int temp=this.picktemp();
        int timing=this.picktiming();
        timer ti = new timer();
        ti.setTimer(timing);
        ti.startHeater(temp);
    }
}
