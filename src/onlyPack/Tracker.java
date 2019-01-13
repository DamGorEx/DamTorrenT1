package onlyPack;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Tracker {
    private static Tracker tracker = null;
    private static HashMap<String,HashMap<Integer,ArrayList<String>>> filesReport = new HashMap<String, HashMap<Integer, ArrayList<String>>>();

    private Tracker(){};
    public static Tracker getTracker(){
        if(tracker == null){
            tracker = new Tracker();
            return tracker;
        }else{
            return tracker;
        }
    }
    public void checkInFiles (String name, Integer partNo, String host){
         if(filesReport.containsKey(name)){
             HashMap<Integer,ArrayList<String>> partMap = filesReport.get(name);
             if(partMap.containsKey(partNo)){
                 ArrayList<String> hostList = partMap.get(partNo);
                 hostList.add(host);

             }else{
                 partMap.put(partNo, new ArrayList<String>(Arrays.asList(host)));

             }
         }else{
             ArrayList<String> hostList = new ArrayList<String>(Arrays.asList(host));
             HashMap<Integer,ArrayList<String>> partMap = new HashMap<Integer,ArrayList<String>>();
             partMap.put(partNo,hostList);
             filesReport.put(name,partMap);
         }
     }
     String showFiles(){
        String key = "";
         for(Map.Entry<String,HashMap<Integer,ArrayList<String>>> entry : filesReport.entrySet()) {
              key += ", " + entry.getKey();
         }
         return "File Names:" + key;
     }
}
