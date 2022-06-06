import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ClassesToTake630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<int[]> scheduleStore = new PriorityQueue<>((a,b)->b[0]-a[0]);

        int totalTimeSum = 0;
        int currLessons = 0;
        for(int i = 0 ; i < courses.length ; i++){
            totalTimeSum += courses[i][0];
            if(totalTimeSum > courses[i][1]) {

                if(scheduleStore.isEmpty()) {
                    totalTimeSum -= courses[i][0];
                    continue;
                }

                int longestLesson = Math.max(scheduleStore.peek()[0],courses[i][0]);
                if(longestLesson == scheduleStore.peek()[0]) {
                    scheduleStore.poll();
                    scheduleStore.add(courses[i]);
                }
                totalTimeSum -= longestLesson;

            } else {
                scheduleStore.add(courses[i]);
                currLessons++;
            }
        }
        return currLessons;
    }

    public static void main(String[] args) {
        int[][] courses1 = {{100,200},{200,1300},{1000,1250},{2000,3200}};
        int[][] courses2 = {{100,2},{32,50}};
        int[][] courses3 = {{7,17},{3,12},{10,20},{9,10},{5,20},{10,19},{4,18}};
        int[][] courses4 = {{9,20},{4,14},{4,10},{6,7},{2,14},{8,10},{6,6},{5,7}};
        ClassesToTake630 test = new ClassesToTake630();
        int ans = test.scheduleCourse(courses4);
        System.out.println(ans);
    }

}

////    If it exceeds deadline, I can swap current course with current courses that has biggest duration.
//if deadline exceed
//then i can swap course with current course that has biggest duration
//
//condtion 1
//current course with biggest duration > the duration of my current course;
//
//condition 2
//course end date increasing?
