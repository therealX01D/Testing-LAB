package org.coffee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class heaterTest {

    @Test
    void setTemp() {
        heater ht =new heater();
        for(int i=0;i<100000;i++){
         assertEquals(i<1000?i:-1,ht.setTemp(i));
        }
    }
}