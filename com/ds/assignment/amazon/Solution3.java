package com.ds.assignment.amazon;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

	static int mod;
	public static void main(String[] args) {
		mod = 1003;
		Solution3 s = new Solution3();
		String str = "T^T^T^F|F";
		int result = s.cnttrue(str);
		System.out.println(result);
	}
	

    public int cnttrue(String str) {
        Map<String, Integer> map = new HashMap<>();
        int result = ways(str, 0, str.length() -1, 'T', map);
        System.out.println(result);
        return result;
    }
    
    public int ways(String str, int i, int j, char exp, Map<String,Integer> map){
        if ( i > j ){
            return 0;
        }
        if (i == j ){
        	return str.charAt(i) == exp ? 1 : 0;
        }
        String key = i + "_" + j + "_" + exp;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int result = 0;
        for (int k = i+1 ; k < j; k+=2 ){
            int leftWayTrue = ways(str, i, k -1, 'T',  map);
            int leftWayFalse = ways(str, i, k -1, 'F', map);
            int rightTrue = ways(str, k + 1, j, 'T',  map);
            int rightFalse = ways(str, k + 1,j, 'F', map);           
            Character operator = str.charAt(k);
            switch(operator){
                case '|' : {
                    if (exp == 'T'){
                        result = result + (leftWayFalse * rightTrue)
                        + (leftWayTrue * rightFalse)  + (leftWayTrue * rightTrue);
                    } else {
                        result = result + (leftWayFalse * rightFalse);
                    }
                }
                break;
                case '&' : {
                    if (exp == 'T'){
                        result = result + (leftWayTrue * rightTrue);
                    } else {
                        result = result + (leftWayTrue * rightFalse) 
                        + (leftWayFalse * rightFalse) + (leftWayFalse * rightTrue);
                    }
                }
                break;
                case '^' : {
                    if (exp == 'T'){
                        result = result + (leftWayTrue * rightFalse) + 
                        (leftWayFalse * rightTrue);
                    } else {
                        result = result + (leftWayFalse * rightFalse)
                        + (leftWayTrue * rightTrue);
                    }
                }
                break;
            }
        }
        map.put(key, (int)result%mod);
        System.out.println("i:" + i + ", j:" + j + ", exp:" + exp + ", r:" + result);
        return (int)result%mod;
    }

}

