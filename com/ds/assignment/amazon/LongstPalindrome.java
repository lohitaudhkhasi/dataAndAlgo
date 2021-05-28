package com.ds.assignment.amazon;

import java.util.HashMap;

public class LongstPalindrome {

	HashMap<String,String> cache = new HashMap<>();
	public static void main(String[] args) {
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		LongstPalindrome l = new LongstPalindrome();
		System.out.println(l.longestPalindrome(s));
	}
	
    public String longestPalindrome(String s) {
        String result = longestPalindrome(s, 0);
        return result;
    }
    
    public String longestPalindrome(String s, Integer max){
        // check if s is palindrome 
        // check if s(1 to end) || s(0, end-1)
    	if (cache.containsKey(s)) {
    		return cache.get(s);
    	}
    	System.out.println(s);
    
        if (s.length() == 1){    
            return s;
        }
        String result = "";
        if (isPalindrome(s)){
           return s;
        } else {
            String s1 = longestPalindrome(s.substring(1, s.length()), max);
            String s2 = longestPalindrome(s.substring(0, s.length()-1), max);
            result = s1.length() > s2.length() ? s1 : s2;
            max = Integer.max(result.length(), max);
        }
        cache.put(s, result);
        Integer i = 0;
        return result; 
    }
    
    public boolean isPalindrome(String s){
        if (s.length() == 1){
            return true;
        }
        int i = 0;
        int j = s.length() -1;
        while( i < j) {
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
