package test.com.gumtree;

import java.util.List;

/**
 * Created by Dilyan B. on 14-5-24.
 */
public class Utils {
    public static boolean compareList(List list1, List list2){
        if (list1.size() != list2.size()) return false;
        for(int i =0; i < list1.size(); i ++) {
            if (!list1.get(i).equals(list2.get(i)))  return false;
        }
        return true;
    }
}
