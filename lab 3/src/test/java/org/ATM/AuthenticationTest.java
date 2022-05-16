package org.ATM;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationTest {

    @Test
    void cardvalid() {
        Authentication at =new Authentication();
        assertEquals("valid",at.cardvalid("0000000000000000"));
        assertEquals("not valid",at.cardvalid("00000000000000"));
    }

    @Test
    void pinvalid() {
        Authentication at =new Authentication();
        assertEquals("valid",at.pinvalid("0000"));
        assertEquals("not valid",at.pinvalid("00000000000000"));
    }

    @Test
    void access() {
        Authentication at =new Authentication();
        assertEquals("No sufficent amount",at.access("0000","0000000000000000","withdrawal",5000000));
        assertEquals("transaction success",at.access("0000","0000000000000000","deposit",500));
        assertEquals("not valid card or pin",at.access("000","00000000000000","deposit",5200));
        assertEquals("undefined mode",at.access("0000","0000000000000000","fubvv",5200));
        assertEquals("cannot complete transaction",at.access("0000","0000000000000000","deposit",-500));
    }
}