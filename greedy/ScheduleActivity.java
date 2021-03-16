package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScheduleActivity {
    class Activity {
        int startTime;
        int finishTime;

        public Activity(int startTime, int finishTime) {
            this.startTime = startTime;
            this.finishTime = finishTime;
        }

        public int getFinishTime() {
            return finishTime;
        }

        @Override
        public String toString() {
            return "Act{" +
                    "s=" + startTime +
                    ", f=" + finishTime +
                    '}';
        }
    }

    public static void main(String[] args) {
        ScheduleActivity s = new ScheduleActivity();
        int startTimes[] = {1, 3, 0, 5, 8, 5};
        int finishTimes[] = {2, 4, 6, 7, 9, 9};
        int noOfActivities = startTimes.length;

        System.out.println(s.printMaxActivities(startTimes, finishTimes, noOfActivities));
    }

    private List<Activity> printMaxActivities(int[] startTimes, int[] finishTimes, int noOfActivities) {
        List<Activity> activities = new ArrayList<>();
        List<Activity> result = new ArrayList<>();
        for (int i = 0; i < noOfActivities; i++) {
            activities.add(new Activity(startTimes[i], finishTimes[i]));
        }
        Collections.sort(activities, Comparator.comparingInt(Activity::getFinishTime));
        result.add(activities.get(0));
        for (int i = 1; i < activities.size(); i++) {
            if (result.get(result.size() - 1).finishTime <= activities.get(i).startTime) {
                result.add(activities.get(i));
            }
        }
        return result;
    }
}
