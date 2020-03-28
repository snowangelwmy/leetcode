import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Q1233 {
    public List<String> removeSubfolders(String[] folder) {
        List<String> result = new ArrayList<>();
        if(folder==null||folder.length==0) {
            return result;
        }

        Arrays.sort(folder);

        boolean[] deleteFlags = new boolean[folder.length];
        for(int i=0; i<folder.length-1; i++) {
            if(deleteFlags[i]) {
                continue;
            }
            for(int j=i+1; j<folder.length; j++) {
                if(deleteFlags[j]) {
                    continue;
                }
                if(folder[j].startsWith(folder[i]+"/")) {
                    deleteFlags[j] = true;
                }
            }
        }

        for(int i=0; i<folder.length; i++) {
            if(!deleteFlags[i]) {
                result.add(folder[i]);
            }
        }

        return result;
    }
}