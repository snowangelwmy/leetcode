/**
 * Test cases:
 * 1: Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * 2: Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 */

import java.util.Set;
import java.util.HashSet;
import java.lang.StringBuffer;

class Q567 {

  private static final int NUM = 26;

  // Approach #5 Sliding Window
  public boolean checkInclusion(String s1, String s2) {
    if(s2==null) {
      return false;
    }
    if(s1==null) {
      return true;
    }
    if(s2.length()<s1.length()) {
      return false;
    }

    int[] s1Counts = new int[NUM];
    int[] s2Counts = new int[NUM];
    for(int i=0; i<s1.length(); i++) {
      s1Counts[s1.charAt(i)-'a']++;
      s2Counts[s2.charAt(i)-'a']++;
    }
    for(int i=0; i<s2.length()-s1.length(); i++) {
      if(matches(s1Counts, s2Counts)) {
        return true;
      }
      s2Counts[s2.charAt(i+s1.length())-'a']++;
      s2Counts[s2.charAt(i)-'a']--;
    }
    return matches(s1Counts, s2Counts);
  }

  // Approach #4 Using Array.
  // Time complexity : O(l1+26*l1*(l2-l1)), where l1 is the length of string s1, and l2 is the length of string s2.
  public boolean checkInclusion1(String s1, String s2) {
    if(s2==null) {
      return false;
    }
    if(s1==null) {
      return true;
    }
    if(s2.length()<s1.length()) {
      return false;
    }

    int[] s1Counts = new int[NUM];
    for(int i=0; i<s1.length(); i++) {
      s1Counts[s1.charAt(i)-'a']++;
    }
    for(int i=0; i<=s2.length()-s1.length(); i++) {
      int[] s2Counts = new int[NUM];
      for(int j=i; j<i+s1.length(); j++) {
        s2Counts[s2.charAt(j)-'a']++;
      }
      if(matches(s1Counts, s2Counts)) {
        return true;
      }
    }
    return false;
  }

  private boolean matches(int[] s1Counts, int[] s2Counts) {
    for(int i=0; i<NUM; i++) {
      if(s1Counts[i]!=s2Counts[i]) {
        return false;
      }
    }
    return true;
  }


  //Approach #1 Brute Force [Time Limit Exceeded]
  public boolean checkInclusion0(String s1, String s2) {
    if(s2==null) {
      return false;
    }
    if(s1==null) {
      return true;
    }
    Set<String> permutation = generatePermutation(s1);
    for(String s : permutation) {
      if(s2.contains(s)) {
        return true;
      }
    }
    return false;
  }

  private Set<String> generatePermutation(String s) {
    Set<String> result = new HashSet<>();
    generatePermutationHelper(result, 0, new StringBuffer(s));
    return result;
  }

  private void generatePermutationHelper(Set<String> result, int index, StringBuffer sb) {
    if(index==sb.length()) {
      result.add(sb.toString());
      return;
    }

    for(int i=index; i<sb.length(); i++) {
      char temp = sb.charAt(index);
      sb.setCharAt(index, sb.charAt(i));
      sb.setCharAt(i, temp);
      generatePermutationHelper(result, index+1, sb);
      sb.setCharAt(i, sb.charAt(index));
      sb.setCharAt(index, temp);
    }
  }
}