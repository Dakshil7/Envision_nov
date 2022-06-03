package InterviewCodes;

import java.util.HashMap;
import java.util.Iterator;

public class DuplicateWordsInString {

    public static void main(String[] args) {
        String str = "I am I I In Love With Love Love Java Java Java Java";
        String strl=str.toLowerCase();
        String[] strArray = strl.split(" ");

        HashMap<String,Integer> hm = new HashMap<>();
        for(String words:strArray){
            if(hm.get(words)==null) {
                hm.put(words, 1);
            }else{
                hm.put(words,hm.get(words)+1);
            }
        }
        System.out.println(hm);

        //for only printing the values of repeated strings we need to iterate it
        Iterator<String> iterator = hm.keySet().iterator();
        while(iterator.hasNext()){
            String getKeys = iterator.next();
            if(hm.get(getKeys)>1){
                System.out.println(getKeys+" = "+hm.get(getKeys));
            }
        }
    }
}
