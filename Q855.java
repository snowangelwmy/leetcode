/**
 * Test cases:
 * 1: Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * Output: [null,0,9,4,2,null,5]
 * Explanation:
 * ExamRoom(10) -> null
 * seat() -> 0, no one is in the room, then the student sits at seat number 0.
 * seat() -> 9, the student sits at the last seat number 9.
 * seat() -> 4, the student sits at the last seat number 4.
 * seat() -> 2, the student sits at the last seat number 2.
 * leave(4) -> null
 * seat() -> 5, the student sits at the last seat number 5.
 */

import java.util.TreeSet;

class ExamRoom {
    int NUM;
    TreeSet<Integer> students;

    public ExamRoom(int N) {
        this.NUM = N;
        this.students = new TreeSet<>();
    }

    //https://leetcode.com/problems/exam-room/solution/
    public int seat() {
        int seat = 0;
        if(this.students.size()>0) {
            int dist = this.students.first(); //the new student sits in the first seat
            Integer preStudent = null;
            for(Integer student : this.students) {
                if(preStudent != null) {
                    int curDist = (student - preStudent)/2;
                    if(curDist>dist) {
                        dist = curDist;
                        seat = preStudent + curDist;
                    }
                }
                preStudent = student;
            }

            if(this.NUM-1-this.students.last() > dist) {
                dist = this.NUM-1-this.students.last();
                seat = this.NUM-1;
            }
        }
        this.students.add(seat);
        return seat;
    }

    public void leave(int p) {
        students.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */