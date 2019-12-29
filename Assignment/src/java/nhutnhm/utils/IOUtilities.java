/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhutnhm.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author SE130162
 */
public class IOUtilities implements Serializable{

    public static Map<String, String> readMapFile(String url) throws FileNotFoundException, IOException {
        File path = new File(url);
        FileReader fr= new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        Map<String, String> map = null;
        String str;
        try {
            while ((str = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(str, "=");
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put(stk.nextToken(), stk.nextToken());
            }
        }finally{
         br.close();
         fr.close();
        }

        return map;
    }
}
