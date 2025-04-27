package app.tecmis.lecture;

import app.tecmis.connection.Config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class CAMarkCalculator {

    public static double calculateCAMark(String courseCode,
                                         Integer assessment1, Integer assessment2,
                                         Integer quiz1, Integer quiz2, Integer quiz3, Integer quiz4,
                                         Integer midTerm) {
        double caMark = 0.0;

        if (courseCode.equals("ICT2122")) {
            ArrayList<Integer> quizList = new ArrayList<>();
            if (quiz1 != null && quiz1 != 0) quizList.add(quiz1);
            if (quiz2 != null && quiz2 != 0) quizList.add(quiz2);
            if (quiz3 != null && quiz3 != 0) quizList.add(quiz3);
            if (quiz4 != null && quiz4 != 0) quizList.add(quiz4);

            double quizMark = bestAverage(quizList, 3) * 0.10;
            double assessmentMark = (assessment1 != null && assessment1 != 0 ? assessment1 : 0) * 0.10;
            double midTermMark = (midTerm != null && midTerm != 0 ? midTerm : 0) * 0.20;

            caMark = quizMark + assessmentMark + midTermMark;
        }
        else if (courseCode.equals("ICT2113")) {
            ArrayList<Integer> quizList = new ArrayList<>();
            if (quiz1 != null && quiz1 != 0) quizList.add(quiz1);
            if (quiz2 != null && quiz2 != 0) quizList.add(quiz2);
            if (quiz3 != null && quiz3 != 0) quizList.add(quiz3);

            double quizMark = bestAverage(quizList, 2) * 0.10;
            double midTermMark = (midTerm != null && midTerm != 0 ? midTerm : 0) * 0.20;

            caMark = quizMark + midTermMark;
        }
        else if (courseCode.equals("ICT2133")) {
            ArrayList<Integer> quizList = new ArrayList<>();
            if (quiz1 != null && quiz1 != 0) quizList.add(quiz1);
            if (quiz2 != null && quiz2 != 0) quizList.add(quiz2);
            if (quiz3 != null && quiz3 != 0) quizList.add(quiz3);

            ArrayList<Integer> assessList = new ArrayList<>();
            if (assessment1 != null && assessment1 != 0) assessList.add(assessment1);
            if (assessment2 != null && assessment2 != 0) assessList.add(assessment2);

            double quizMark = bestAverage(quizList, 2) * 0.10;
            double assessmentMark = bestAverage(assessList, 2) * 0.20;

            caMark = quizMark + assessmentMark;
        }
        else if (courseCode.equals("ICT2142")) {
            double assessmentMark = (assessment1 != null && assessment1 != 0 ? assessment1 : 0) * 0.20;
            double midTermMark = (midTerm != null && midTerm != 0 ? midTerm : 0) * 0.20;

            caMark = assessmentMark + midTermMark;
        }
        else if (courseCode.equals("ICT2152")) {
            ArrayList<Integer> quizList = new ArrayList<>();
            if (quiz1 != null && quiz1 != 0) quizList.add(quiz1);
            if (quiz2 != null && quiz2 != 0) quizList.add(quiz2);
            if (quiz3 != null && quiz3 != 0) quizList.add(quiz3);

            ArrayList<Integer> assessList = new ArrayList<>();
            if (assessment1 != null && assessment1 != 0) assessList.add(assessment1);
            if (assessment2 != null && assessment2 != 0) assessList.add(assessment2);

            double quizMark = bestAverage(quizList, 2) * 0.10;
            double assessmentMark = bestAverage(assessList, 2) * 0.20;

            caMark = quizMark + assessmentMark;
        }

        return caMark;
    }

    private static double bestAverage(ArrayList<Integer> marks, int bestCount) {
        if (marks.isEmpty()) return 0;
        Collections.sort(marks);
        int size = marks.size();
        int startIndex = Math.max(size - bestCount, 0);
        int sum = 0;
        for (int i = startIndex; i < size; i++) {
            sum += marks.get(i);
        }
        return sum / (double) (size - startIndex);
    }

    private static void caEligibility() {
        Connection con = Config.getConfig();
        String selectSql = "SELECT * FROM mark";
        String eligibility = null;
        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(selectSql)
        ) {
            System.out.printf("%-10s %-10s %-10s %-10s%n", "StudentID", "Course", "CA Mark", "Eligibility");
            System.out.println("---------------------------------------------------");

            while (rs.next()) {
                String studentId = rs.getString("student_id");
                String courseCode = rs.getString("course_code");

                Integer aS1 = (int) rs.getFloat("assesment_1");
                Integer aS2 = (int) rs.getFloat("assesment_2");
                Integer q1 = (int) rs.getFloat("quiz_1");
                Integer q2 = (int) rs.getFloat("quiz_2");
                Integer q3 = (int) rs.getFloat("quiz_3");
                Integer q4 = (int) rs.getFloat("quiz_4");
                Integer mid = (int) rs.getFloat("mid_term");

                double caMark = calculateCAMark(courseCode, aS1, aS2, q1, q2, q3, q4, mid);

                if(courseCode.equals("ICT2113") || courseCode.equals("ICT2133") || courseCode.equals("ICT2152")) {
                    eligibility = caMark >= 15.0 ? "EL" : "NE";
                } else if (courseCode.equals("ICT2122") || courseCode.equals("ICT2142")) {
                    eligibility = caMark >= 19.5 ? "EL" : "NE";
                }

                System.out.printf("%-10s %-10s %-10.2f %-10s%n", studentId, courseCode, caMark, eligibility);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
