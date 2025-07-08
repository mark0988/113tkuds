// 檔名：GradeProcessor.java
public class GradeProcessor {
    public static void main(String[] args) {
        
        int[] grades = {78, 85, 92, 67, 88, 95, 73, 90};

        
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        double average = (double) total / grades.length;

        System.out.println("總分: " + total);
        System.out.printf("平均分數: %.2f\n", average);

        
        int max = grades[0], min = grades[0];
        int maxIndex = 0, minIndex = 0;

        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
                maxIndex = i;
            }
            if (grades[i] < min) {
                min = grades[i];
                minIndex = i;
            }
        }

        System.out.println("最高分: " + max + "，索引: " + maxIndex);
        System.out.println("最低分: " + min + "，索引: " + minIndex);

        
        int countAboveAverage = 0;
        for (int grade : grades) {
            if (grade > average) {
                countAboveAverage++;
            }
        }
        System.out.println("成績高於平均的人數: " + countAboveAverage);

        
        System.out.println("學生成績列表：");
        for (int i = 0; i < grades.length; i++) {
            System.out.println("學生 " + i + ": " + grades[i]);
        }
    }
}
