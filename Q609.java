/**
 * Test cases:
 * 1: Input:
 * ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
 * Output:
 * [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Q609 {

    private static final String BLANK = " ";
    private static final String LEFT = "(";
    private static final String SLASH = "/";

    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        if(paths==null||paths.length==0) {
            return result;
        }

        Map<String, List<String>> lookup = new HashMap<>();
        for(String path : paths) {
            String[] array = path.split(BLANK);
            String root = array[0];
            for(int i=1; i<array.length; i++) {
                String file = array[i];
                int index = file.indexOf(LEFT);
                String fileName = file.substring(0, index);
                String fileContent = file.substring(index+1, file.length()-1);
                if(!lookup.containsKey(fileContent)) {
                    lookup.put(fileContent, new ArrayList<String>());
                }
                lookup.get(fileContent).add(root+SLASH+fileName);
            }
        }

        for(List<String> value : lookup.values()) {
            if(value.size()>1) {
                result.add(value);
            }
        }

        return result;
    }
}