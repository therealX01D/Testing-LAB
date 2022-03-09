import java.util.*;
public class main {
    public String ifdev(int weight){
        boolean isdiv=false;
        if(weight>100 || weight < 1)
            return null;
        for (int i =1;i<=weight/2;i++){
            for (int j=weight-1;j>=weight/2;j--){
                if(j+i == weight && j%2==0 && i%2==0) {
                    isdiv = true;
                    break;
                }
            }
            if(isdiv) break;
        }
        return isdiv?"YES":"NO";
    }
    public String forcesum(int[] a,int[] b ,int[] c ){
        int suma=0,sumb=0,sumc=0;
        int n =a.length;
        boolean inrange=true;
        for (int i =0 ; i<a.length;i++){
            inrange =inrange && a[i]>=-100 &&a[i]<=100&& b[i]<=100&&b[i]>=-100&&c[i]<=100 && c[i]>=-100;
            suma+=a[i];
            sumb+=b[i];
            sumc+=c[i];
        }
        return n>=1&&n<=100?(inrange?(suma==0&&sumb==0&&sumc==0?"YES":"NO"):"NULL"):"NULL";
    }


    public static void main(String[] args) {
   /*A4 WATERMELON PROBLEM
        Scanner sc = new Scanner(System.in);
        main m =new main();
        System.out.println( m.ifdev(sc.nextInt()));
    */
     /*A69 young physicist
        main m =new main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a=0,b=0,c=0
                ,suma=0
                ,sumb=0
                ,sumc=0;
        int tmp=n;
        boolean inrange =true;
        while(tmp>0){
            a=sc.nextInt();
            b=sc.nextInt();
            c=sc.nextInt();
            inrange =inrange && a>=-100 &&a<=100&& b<=100&&b>=-100&&c<=100 && c>=-100;
            suma+=a;
            sumb+=b;
            sumc+=c;
            tmp--;
        }

        System.out.println(n>=1&&n<=100?(inrange?(suma==0&&sumb==0&&sumc==0?"YES":"NO"):"NULL"):"NULL");
    }*/
    }
}
