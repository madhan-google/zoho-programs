import java.io.*;
import java.util.*;
class A{
    int count;
    A(){
        count = 0;
        System.out.println("im A");
    }
}
class B extends A{
    B(){
        System.out.println("im B");
        count = 10;
    }
}
public class Main {
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        // int a = sn.nextInt();
        // int b = sn.nextInt();
        // System.out.println(a+" -\t"+Integer.toBinaryString(a));
        // System.out.println(b+" -\t"+Integer.toBinaryString(b));
        // System.out.println((a|b)+" -\t"+Integer.toBinaryString((a|b)));
        // System.out.println((sn.next().charAt(0))<(sn.next().charAt(0)));
        A a = new A();
        System.out.println(a.count);
        B b = new B();
        System.out.println(a.count);
    }
}
