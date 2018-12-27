import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
  public List<String> readBinaryWatch(int num) {
    List<String> times = new ArrayList<>();
    if(num<0||num>10){
      return times;
    }
    //0<=num<=10
    int[] hour = new int[4];
    int[] minute = {0, 0, 0, 0, 0, 0};
    Set<String> timesSet = new HashSet<>();
    readBinaryWatchDfs(hour, minute, 0, num, 0, 0, timesSet);
    times.addAll(timesSet);
    return times;
  }

  private void readBinaryWatchDfs2(int[] hour, int[] minute, int count, int num, int i, int j, Set<String> times) {
    if(i==hour.length&&j==minute.length){
      if(count==num) {
        addTime(hour, minute, times);
      }
      return;
    } else if(i==hour.length){
      if(count<num){
        minute[j] = 1;
        readBinaryWatchDfs(hour, minute, count+1, num, i, j+1, times);
      }
      minute[j] = 0;
      readBinaryWatchDfs(hour, minute, count, num, i, j+1, times);
    } else if(j==minute.length) {
      if(count<num){
        hour[i] = 1;
        readBinaryWatchDfs(hour, minute, count+1, num, i+1, j, times);
      }
      hour[i] = 0;
      readBinaryWatchDfs(hour, minute, count, num, i+1, j, times);
    } else {//i<hour.length&&j<minute.length
      if(count<num){
        hour[i] = 1;
        minute[j] = 0;
        readBinaryWatchDfs(hour, minute, count+1, num, i+1, j, times);
        hour[i] = 0;
        minute[j] = 1;
        readBinaryWatchDfs(hour, minute, count+1, num, i, j+1, times);
      }
      hour[i] = 0;
      minute[j] = 0;
      readBinaryWatchDfs(hour, minute, count, num, i+1, j+1, times);
    }
  }


  private void readBinaryWatchDfs1(int[] hour, int[] minute, int count, int num, int i, int j, Set<String> times) {
    if(i==hour.length&&j==minute.length){
      if(count==num) {
        addTime(hour, minute, times);
      }
      return;
    }

    if(i<hour.length){
      if(count<num){
        hour[i] = 1;
        readBinaryWatchDfs(hour, minute, count+1, num, i+1, j, times);
      }
      hour[i] = 0;
      readBinaryWatchDfs(hour, minute, count, num, i+1, j, times);
    }
    if(j<minute.length){
      if(count<num){
        minute[j] = 1;
        readBinaryWatchDfs(hour, minute, count+1, num, i, j+1, times);
      }
      minute[j] = 0;
      readBinaryWatchDfs(hour, minute, count, num, i, j+1, times);
    }
  }

  private void addTime(int[] hour, int[] minute, Set<String> times) {
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