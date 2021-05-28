package com.ds.assignment.amazon;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution11 {

    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {
        if (arr.length < 3){
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int counter = 0;
        for( int i = 0 ; i < arr.length; i++){
            if (map.containsKey(arr[i] - d) && map.containsKey(arr[i] - (2*d))) {
                counter = counter + 
                    (map.get(arr[i] -d).size() * map.get(arr[i] - 2*d).size());
            }
            if (!map.containsKey(arr[i])){
                map.put(arr[i], new ArrayList<Integer>());
            }
            if (!map.containsKey(arr[i] + d)){
                map.put(arr[i] + d, new ArrayList<Integer>());
            }
            map.get(arr[i]).add(i);
            map.get(arr[i] + d).add(i);
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
