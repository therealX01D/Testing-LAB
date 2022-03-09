import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.*;
public class mainTest {
    @Test
    /*
    * A4_WATERMELON TESTS ONE BASED ON A FOR LOOP WITH ONE OUT OF codeforces in the _fixed function
    * and compare it with the even of the number (if its even or not unless its a two)
    * */
public void A4_test(){
    main m =new main();
    for(int i =0;i<200;i++){
        String res = (i>=1&&i<=100)? ((i%2==0&&i!=2)?"YES":"NO"):null;
        System.out.println("i"+i+" : "+res);
        Assert.assertTrue(m.ifdev(i) == res);
    }
    }
    @Test
    public void A4_test_fixed(){
        main m=new main();
        int in [] = {8,5,4,3,2,1,7,6,10,9,53,77,32,44,98,99,90,67,100,88};
        String out [] ={"YES","NO","YES","NO","NO","NO","NO","YES","YES","NO","NO","NO","YES","YES","YES","NO","YES","NO","YES","YES"};
        for (int i=0; i<in.length;i++){
            Assert.assertTrue(m.ifdev(in[i])==out[i]);
        }
    }
    /*
    * A69_young physicist
    * used an testcase from codeforce as an multidimensional array where each element is supposedly an testcase and its
    * checked with an sum function from java.lang library and also checked ranges
    * */
    @Test
    public void A69_test_fixed(){
        main m =new main();
        int in [][][]={{{29,49,-11},{38 ,-11,-20},{25 ,1, 40},
                {-11,28, 11},
                {23,-19, 1},
                {45,-41, -17},
                {-3 ,0, -19},
                {-13,-33, 49},
                {-30,0,28},
                {34 ,17, 45},
                {-50,9, -27},
                {-50 ,0, 0},
                {-37 ,0, 0}}};
        int[][] tsc1=in[0];
        int[]x=new int[in[0].length],y=new int[in[0].length],z=new int[in[0].length];
        for (int i =0; i< x.length;i++){
            x[i]=in[0][i][0];
            y[i]=in[0][i][1];
            z[i]=in[0][i][1];
        }
        Arrays.sort(x);
        Arrays.sort(y);
        Arrays.sort(z);
        boolean range=Math.abs(x[0])<100&&Math.abs(x[x.length-1])<100
                &&Math.abs(y[0])<100&&Math.abs(y[y.length-1])<100
                &&Math.abs(z[0])<100&&Math.abs(z[z.length-1])<100;

        Assert.assertTrue((range&&IntStream.of(x).sum()==0&&IntStream.of(y).sum()==0&&IntStream.of(z).sum()==0?"YES":"NO")==m.forcesum(x,y,z));

        /*String out[]={
                "YES"
        };
        int x=0,y=0,z=0;
        String strarr[]=new String[in[0].length];

        /*for(int i =0 ; i<in.length;i++){
            for (int j=0;j<in[i].length;j++){
                x+=in[i][j][0];
                y+=in[i][j][1];
                z+=in[i][j][2];
            }
            strarr[i]=x==0&&y==0&&z==0?"YES":"NO";
        }*/
    }
}