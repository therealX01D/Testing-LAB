package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void paritychecker() {
        Main m = new Main();
        for(int i=0; i<600; i++) {
            String exp= i%2==0?"even":"odd";
            Assertions.assertEquals(m.paritychecker(i),exp);
        }
    }

    @Test
    void maxandmin() {
        Main m = new Main();
        int[] x={1,23,4,5,487,8,15,488,45,15,86,5,484,555,-55,49,4,9};
        String exp="555,-55";
        Assertions.assertEquals(exp,m.maxandmin(x));
    }
}