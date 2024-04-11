package service;

public class MyService {
    public static int hap(){  // MyService.hap()
        int sum=0;
        for(int i=1;i<=10;i++){
            sum+=i;
        }
        return sum;
    }
    public static int hap(int su1, int su2){  // MyService.hap()
        int sum=0;
        for(int i=su1;i<=su2;i++){
            sum+=i;
        }
        return sum;
    }
}
