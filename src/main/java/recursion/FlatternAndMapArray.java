package recursion;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author saurabh vaish
 * @Date 09-08-2022
 */
public class FlatternAndMapArray {  // not working

//    private final static String data = "[{\"name\":\"Desktop\",\"id\":\"12345\",\"hierarchy\":[{\"name\":\"work\",\"id\":\"12345-sub\",\"hierarchy\":[{\"name\":\"proj1\",\"id\":\"667734\",\"hierarchy\":[{\"name\":\"components\",\"id\":\"565646\",\"hierarchy\":[]}]}]},{\"name\":\"company\",\"id\":\"12345-sub\",\"hierarchy\":[]}]},{\"name\":\"laptop\",\"id\":\"897\",\"hierarchy\":[{\"name\":\"Documents\",\"id\":\"12345-sub\",\"hierarchy\":[]},{\"name\":\"Downloads\",\"id\":\"12345-sub\",\"hierarchy\":[{\"name\":\"Teshla\",\"id\":\"12345\",\"hierarchy\":[]}]}]},{\"name\":\"hybrid\",\"id\":\"1123\",\"hierarchy\":[]}]";
    private final static String data = "[ { \"name\":\"Documents\", \"id\":\"12345\", \"hierarchy\":[ { \"name\":\"work\", \"id\":\"12345-sub\", \"hierarchy\":[ { \"name\":\"Expenses.doc\", \"id\":\"667734\", \"hierarchy\":[ ] }, { \"name\":\"Resumes.doc\", \"id\":\"667734\", \"hierarchy\":[ ] } ] }, { \"name\":\"home\", \"id\":\"12345-sub\", \"hierarchy\":[ { \"name\":\"Invoices.doc\", \"id\":\"667734\", \"hierarchy\":[ ] } ] } ] }, { \"name\":\"Pictures\", \"id\":\"897\", \"hierarchy\":[ { \"name\":\"Documents\", \"id\":\"12345-sub\", \"hierarchy\":[ { \"name\":\"barcelona.doc\", \"id\":\"667734\", \"hierarchy\":[ ] }, { \"name\":\"logo.doc\", \"id\":\"667734\", \"hierarchy\":[ ] }, { \"name\":\"primeui.doc\", \"id\":\"667734\", \"hierarchy\":[ ] } ] }, { \"name\":\"Movies\", \"id\":\"12345-sub\", \"hierarchy\":[ { \"name\":\"Teshla\", \"id\":\"12345\", \"hierarchy\":[ { \"name\":\"Scarface\", \"id\":\"12345\", \"hierarchy\":[] }, { \"name\":\"Serpico\", \"id\":\"12345\", \"hierarchy\":[] } ] }, { \"name\":\"Robert de niro\", \"id\":\"12345\", \"hierarchy\":[ { \"name\":\"Goodfellas\", \"id\":\"12345\", \"hierarchy\":[] }, { \"name\":\"untouchables\", \"id\":\"12345\", \"hierarchy\":[] } ] } ] } ] } ]";
    private static class Hierarchy{
        private String name;
        private String label;
        private String id;
        private Hierarchy[] hierarchy = new Hierarchy[0];
        private Hierarchy[] children = new Hierarchy[0];

    }

    private static Hierarchy[] dataList= new Hierarchy[100];

    public static void main(String[] args) {
        Gson gson = new Gson();
        Hierarchy[] hierarchy = gson.fromJson(data,Hierarchy[].class);
        System.out.println(hierarchy);
//        convert(hierarchy,null,0, 0);
        map(hierarchy,0);
        System.out.println(gson.toJson(hierarchy));
    }


    private static void convert2(Hierarchy[] hierarchies,int i) {
        int j=0,k=-1;
        for (Hierarchy h : hierarchies) {
            h.label=h.name;
            if(h.hierarchy.length>0){
                for (Hierarchy h1:h.hierarchy){
                    h1.label=h1.name;
                    if(h1.hierarchy.length>0){
                        for (Hierarchy h2:h.hierarchy){
                            h2.label=h2.name;
                            if(h2.hierarchy.length>0){
                                for (Hierarchy h3:h2.hierarchy){
                                    h3.label=h3.name;
                                    if(h3.hierarchy.length>0){
                                            for (Hierarchy h4:h3.hierarchy){
                                                h4.label=h4.name;
                                                if(h4.hierarchy.length>0){
                                                    for (Hierarchy h5:h4.hierarchy){
                                                        h5.label=h5.name;
                                                    }
                                                }
                                                h4.children=h4.hierarchy;
                                            }
                                    }
                                    h3.children=h3.hierarchy;
                                }
                            }
                            h2.children=h2.hierarchy;
                        }
                    }
                    h1.children=h1.hierarchy;
                }
            }
            h.children=h.hierarchy;
        }

    }

    private static void convert(Hierarchy[] hierarchies,Hierarchy hh,int i,int len) {
        if(hierarchies.length==len){
            if(hh!=null){
                hh.label= hh.name;
                hh.children=new Hierarchy[0];
            }
            return;
        }
        int j=0,k=-1;

        for (int l = i; l < hierarchies.length; l++) {
            Hierarchy data = new Hierarchy();
            data.label=hierarchies[l].name;
            convert(hierarchies[l].hierarchy,hierarchies[l],l+1,len+1);
            data.children=hierarchies[l].hierarchy;
            hierarchies[l].children=data.children;
        }
//
//        for (Hierarchy h : hierarchies) {
//            Hierarchy hierarchy = new Hierarchy();
//            hierarchy.label=h.name;
//            hierarchy.children=h.hierarchy;
//            convert(h.hierarchy,++k,len);
//            h=hierarchy;
//        }

//        convert(hierarchies,null,++i,len);
//        dataList[i]=hierarchies[i];
//        len++;
    }


//    private static void convert3(Hierarchy hierarchy,int i,int size) {
//        if(i==size){
//            return;
//        }
//        int j=0,k=-1;
//            Hierarchy hr = new Hierarchy();
//            hr.label=hierarchy.name;
//            convert2(h.hierarchy,++k,len);
//        hierarchy.children=h.hierarchy;
//        h=hierarchy;
//
//        convert(hierarchies,++i,len);
//        len++;
//    }

    private static void map(Hierarchy[] hierarchies,int index){
        for (int i = index; i < hierarchies.length; i++) {
            Hierarchy h = hierarchies[i];
            Hierarchy hh = convert3(h, i, 0);

        }
    }

    private static Hierarchy convert3(Hierarchy hierarchy,int i,int size) {
      if(hierarchy!=null && hierarchy.hierarchy.length==0){
          hierarchy.label=hierarchy.name;
          hierarchy.children = new Hierarchy[0];
          return hierarchy;
      }
//      Hierarchy h = new Hierarchy();
      hierarchy.label= hierarchy.name;
      hierarchy.id= hierarchy.id;
      if(hierarchy.hierarchy.length>0){
          map(hierarchy.hierarchy,i);
      }
        hierarchy.children=hierarchy.hierarchy;
        return hierarchy;
    }



}
