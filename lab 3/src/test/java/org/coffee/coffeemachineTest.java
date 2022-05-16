package org.coffee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class coffeemachineTest {


    @Test
    void picktiming() {
        coffeemachine cm =new coffeemachine();
        cm.setType("Black");
        assertTrue(cm.picktiming()==1000);
        cm.setType("latte");
        assertTrue(cm.picktiming()==500);
    }

    @Test
    void picktemp() {
        coffeemachine cm =new coffeemachine();
        cm.setType("Black");
        assertTrue(cm.picktemp()==25);
        cm.setType("latte");
        assertTrue(cm.picktemp()==30);
    }

    @Test
    void startmaking() {
    }
}