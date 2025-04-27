package app.tecmis.lecture;

public class Grade {

        private String course_code;
        private String grade;
        private String stuId;

        public Grade(String course_code, String grade, String stuId) {
            this.course_code = course_code;
            this.grade = grade;
            this.stuId = stuId;
        }

        public String getCourse_code() {
            return course_code;
        }

        public String getGrade() {
            return grade;
        }

        public String getStuId() {
            return stuId;
        }
    }

