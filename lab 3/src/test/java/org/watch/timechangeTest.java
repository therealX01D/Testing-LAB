package org.watch;

import static org.junit.jupiter.api.Assertions.*;

class timechangeTest {

    @org.junit.jupiter.api.Test
    void incminutetest() {
        timechange tm = new timechange();
        for(int i=0;i<60;i++)tm.incminute();
        String tmp=tm.returnTIME();
        assertEquals("1:1",tmp);
    }

    @org.junit.jupiter.api.Test
    void inchour() {
        timechange tm = new timechange();
        for(int i=0;i<24;i++)tm.inchour();
        String tmp=tm.returnTIME();
        assertEquals("0:"+tm.m,tmp);
        assertEquals("2000-1-2",tm.returnDate());
    }

    @org.junit.jupiter.api.Test
    void incday() {
        timechange tm = new timechange();
        for(int i=0;i<30;i++)tm.incday();
        assertEquals("2000-2-1",tm.returnDate());
    }

    @org.junit.jupiter.api.Test
    void incmonth() {
        timechange tm = new timechange();
        for(int i=0;i<12;i++)tm.incmonth();
        assertEquals("2001-2-1",tm.returnDate());
    }

    @org.junit.jupiter.api.Test
    void incyear() {
        timechange tm = new timechange();
        for(int i=0;i<99;i++)tm.incyear();
        assertEquals("2000-1-1",tm.returnDate());
    }
}