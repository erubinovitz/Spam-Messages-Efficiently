/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Evan
 */
import java.lang.Math;
public class SpamMessagesEfficiently {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println(spam(150));
    }
    public static int spam(int n){
        String[] s = new String[n+1];
        int[] b =new int[n+1];
        int a= spam(n,b, s);   
     /*   int minIndex=-1;
        int min=n;
        for (int i=1; i<=n; i++){
            if (min>b[i]){
                min=b[i];
                minIndex=i;
            }
            System.out.println(s[i]);
        }*/
        System.out.println(s[n]);
        return a;
    }
    public static int spam(int n, int[] arr,String[] instructions){
        if (n==1){
            arr[n]=1;
            instructions[n]="V";
            return 1;
            
        }
       
        int min=n;
        for (int i=1; i<n; i++){
            if (arr[i]!=0){
                int a =arr[i]+2+(int)Math.ceil((double)(1.0*(n-i)/(i)));
                if (min>a){
                    instructions[n]=instructions[i]+"AC";
                    for(int j=0; j<a-arr[i]-2; j++){
                        instructions[n]+="V";
                     //   System.out.println("j = " +j+ " a = " +a);
                      //  System.out.println(((double)(1.0*n/(n-i))+" n is " +n+ " i is "+i));
                    }
                }
                min=min(min,a);  
              //  System.out.println("min is " + min + " i is " +i +" n is " + n);
            }
            else{
                int b = spam(i,arr,instructions);
                arr[n]=b;
                int a = b+2+(int)Math.ceil((double)(1.0*(n-i)/(i)));
                if (min>a){
                    instructions[n]=instructions[i]+"AC";
                    for(int j=0; j<a-b-2; j++){
                        instructions[n]+="V";
                      //  System.out.println("j = " +j);
                    }
                }
                min=min(min,a);  
              //  System.out.println("min is " + min +" i is " + i +" n is " + n);
            }
        }
        arr[n]=min;
        if (instructions[n]==null)
            instructions[n]=instructions[n-1]+"V";
        return min;
    }
   public static int min(int a, int b){
       if (a>b)
           return b;
       return a;
   }
    
}
