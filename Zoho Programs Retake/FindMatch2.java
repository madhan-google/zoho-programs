import java.io.*;
import java.util.*;
class Info{
    String name;
    String gender;
    Info father;
    Info mother;
    Info[] siblings;
    Info[] childs;
    int scount, ccount;
    Info(){
        scount = 0;
        ccount = 0;
        father = null;
        mother = null;
        siblings = new Info[10];
        childs = new Info[10];
    }
    @Override
    public String toString(){
        return this.name;
    }
}
public class FindMatch2 {
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        int n = sn.nextInt();
        Info[] infos = new Info[n];
        for(int i=0; i<n; i++){
            String name = sn.next();
            String gender = sn.next();
            String fatherName = sn.next();
            String motherName = sn.next();
            Info info = new Info();
            info.name = name;
            info.gender = gender;
            // searching father exist in list or not
            for(int j=0; j<i; j++){
                if(infos[j]!=null&&fatherName.equals(infos[j].name)){
                    info.father = infos[j];
                    info.father.childs[info.father.ccount++] = info;
                    break;
                }
            }
            if(info.father==null){
                info.father = new Info();
                info.father.name = fatherName;
                info.father.gender = "male";
            }
            // System.out.println("name : "+info.name+" father "+info.father.name);
            //searching mother exist in list or not
            for(int j=0; j<i; j++){
                if(infos[j]!=null&&motherName.equals(infos[j].name)){
                    info.mother = infos[j];
                    info.mother.childs[info.mother.ccount++] = info;
                    break;
                }
            }
            if(info.mother==null){
                info.mother = new Info();
                info.mother.name = motherName;
                info.mother.gender = "female";
            }
            // System.out.println("name : "+info.name+" mother "+info.mother.name);

            //searching for siblings
            System.out.print("\nname : "+info.name+" ");
            for(int j=0; j<i; j++){
                System.out.println(infos[j].father.name);
                if(infos[j]!=null&&fatherName.equals(infos[j].father.name)){
                    infos[j].siblings[infos[j].scount++] = info;
                    info.siblings[info.scount++] = infos[j];
                }
            }
            // System.out.println("Name : "+info.name+" siblings "+Arrays.toString(info.siblings));

            infos[i] = info;
        }
        // for(int i=0; i<n; i++){
        //     System.out.println(infos[i]);
        // }
        String inp = sn.next();
        Info temp = null;
        for(int i=0; i<n; i++){
            // System.out.println("childs : "+Arrays.toString(infos[i].siblings));
            if(infos[i].name.equals(inp)){
                temp = infos[i];
                break;
            }
        }
        // finding aunties childrens
        if(temp.father.scount!=0){
            for(int i=0; i<temp.father.scount; i++){
                Info sibling = temp.father.siblings[i];
                if(sibling!=null&&sibling.gender.equals("female")){
                    for(int j=0; j<sibling.ccount; j++){
                        Info inf = sibling.childs[j];
                        if(inf!=null&&!temp.gender.equals(inf.gender)){
                            System.out.print(inf.name+" ");
                        }
                    }
                }
            }
        }
        // finding uncles childrens
        if(temp.mother.scount!=0){
            for(int i=0; i<temp.mother.scount; i++){
                Info sibling = temp.mother.siblings[i];
                if(sibling!=null&&sibling.gender.equals("male")){
                    for(int j=0; j<sibling.ccount; j++){
                        Info inf = sibling.childs[j];
                        if(inf!=null&&!temp.gender.equals(inf.gender)){
                            System.out.print(inf.name+" ");
                        }
                    }
                }
            }
        }
    }
}
