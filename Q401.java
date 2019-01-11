/**
 * Test cases:
 * 1: Input: n = 1
 * Output: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * 2: Input: n = 0
 * Output: ["0:00"]
 * 3: Input: n = 2
 * Output: ["0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"]
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Q401 {

  public List<String> readBinaryWatch2(int num) {
    List<String> times = new ArrayList<>();
    if(num<0||num>10){
      return times;
    }
    //0<=num<=10
    for(int i=0; i<12; i++){
      for(int j=0; j<60; j++){
        int orNum = ((i<<6)|j);
        int bitCount = bitCount(orNum);
        if(bitCount==num){
          addTime(i, j, times);
        }
      }
    }
    return times;
  }

  private int bitCount(int num){
    int bitCount = 0;
    int mask = 1;
    for(int i=0; i<10; i++){
      if((num&mask)!=0){
        bitCount++;
      }
      mask <<= 1;
    }
    return bitCount;
  }

  private void addTime(int hours, int minutes, List<String> times) {
    StringBuilder builder = new StringBuilder();
    builder.append(String.valueOf(hours));
    builder.append(":");
    if(minutes<10){
      builder.append("0"+minutes);
    } else {
      builder.append(String.valueOf(minutes));
    }
    times.add(builder.toString());
  }

  public List<String> readBinaryWatch1(int num) {
    List<String> times = new ArrayList<>();
    if(num<0||num>10){
      return times;
    }
    //0<=num<=10
    int[] hour = new int[4];
    int[] minute = {0, 0, 0, 0, 0, 0};
    Set<String> timesSet = new HashSet<>();
    readBinaryWatchDfs1_2(hour, minute, 0, num, 0, 0, timesSet);
    times.addAll(timesSet);
    return times;
  }

  private void readBinaryWatchDfs1_2(int[] hour, int[] minute, int count, int num, int i, int j, Set<String> times) {
    if(i==hour.length&&j==minute.length){
      if(count==num) {
        addTime1(hour, minute, times);
      }
      return;
    } else if(i==hour.length){
      if(count<num){
        minute[j] = 1;
        readBinaryWatchDfs1_2(hour, minute, count+1, num, i, j+1, times);
      }
      minute[j] = 0;
      readBinaryWatchDfs1_2(hour, minute, count, num, i, j+1, times);
    } else if(j==minute.length) {
      if(count<num){
        hour[i] = 1;
        readBinaryWatchDfs1_2(hour, minute, count+1, num, i+1, j, times);
      }
      hour[i] = 0;
      readBinaryWatchDfs1_2(hour, minute, count, num, i+1, j, times);
    } else {//i<hour.length&&j<minute.length
      if(count<num){
        hour[i] = 1;
        minute[j] = 0;
        readBinaryWatchDfs1_2(hour, minute, count+1, num, i+1, j, times);
        hour[i] = 0;
        minute[j] = 1;
        readBinaryWatchDfs1_2(hour, minute, count+1, num, i, j+1, times);
      }
      hour[i] = 0;
      minute[j] = 0;
      readBinaryWatchDfs1_2(hour, minute, count, num, i+1, j+1, times);
    }
  }


  private void readBinaryWatchDfs1_1(int[] hour, int[] minute, int count, int num, int i, int j, Set<String> times) {
    if(i==hour.length&&j==minute.length){
      if(count==num) {
        addTime1(hour, minute, times);
      }
      return;
    }

    if(i<hour.length){
      if(count<num){
        hour[i] = 1;
        readBinaryWatchDfs1_1(hour, minute, count+1, num, i+1, j, times);
      }
      hour[i] = 0;
      readBinaryWatchDfs1_1(hour, minute, count, num, i+1, j, times);
    }
    if(j<minute.length){
      if(count<num){
        minute[j] = 1;
        readBinaryWatchDfs1_1(hour, minute, count+1, num, i, j+1, times);
      }
      minute[j] = 0;
      readBinaryWatchDfs1_1(hour, minute, count, num, i, j+1, times);
    }
  }

  private void addTime1(int[] hour, int[] minute, Set<String> times) {
    int hours = 0;
    for(int i=0; i<hour.length; i++){
      if(hour[i]==1){
        hours += Math.pow(2, i);
      }
    }
    int minutes = 0;
    for(int i=0; i<minute.length; i++){
      if(minute[i]==1){
        minutes += Math.pow(2, i);
      }
    }
    if(hours<12&&minutes<60){
      StringBuilder builder = new StringBuilder();
      builder.append(String.valueOf(hours));
      builder.append(":");
      if(minutes<10){
        builder.append("0"+minutes);
      } else {
        builder.append(String.valueOf(minutes));
      }
      times.add(builder.toString());
    }
  }
}