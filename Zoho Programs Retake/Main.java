import java.io.*;
import java.util.*;
class Parent{
    int count;
    static List<Integer> list = new ArrayList<>();
    Parent(){
        count = 0;
        // list = new ArrayList<>();
    }
}
class A extends Parent{
    A(){
        System.out.println("im A");
        count = 10;
    }
    public void setInt(int x){
        list.add(x);
    }
    public List<Integer> get(){
        return list;
    }
    public void show(){
        System.out.println(list);
    }
}
class B extends Parent{
    B(){
        System.out.println("im B");
    }
    public void setInt(int x){
        list.add(x);
    }
    public List<Integer> get(){
        return list;
    }
    public void show(){
        System.out.println(list);
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
        B b = new B();
        a.setInt(10);
        a.setInt(20);
        a.setInt(30);
        a.get().add(40);
        b.show();
        
    }
}
