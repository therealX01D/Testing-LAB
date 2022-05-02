package org.example;

public class Main {
    public String paritychecker(int in){
        String str="odd";
        if (in==0) return "even";
        for(int i  =0 ;i< in;i++) {
            if(i*2==in){
                str="even";
            }
        }
        return str;
    }
    public String maxandmin(int[] in){
        int max=in[0],min=in[0];
        for(int i =0 ; i<in.length;i++){
            max=in[i]>max?in[i]:max;
            min=in[i]<min?in[i]:min;
        }
        return Integer.toString(max)+','+Integer.toString(min);
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int x[]={2,5,1,4,6,1,5,2,2};
        Main m=new Main();
        System.out.println("maximum of array and minimum is"+m.maxandmin(x));
        statesofclock st = new statesofclock();
        st.DisplayTIME();
        st.DisplayDate();
        st.inputs("abadcababababa");
        st.DisplayDate();
        st.DisplayTIME();
    }
}