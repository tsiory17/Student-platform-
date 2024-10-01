public class FrenchCourse implements ICourse{

        Course course = new Course();

        public void buildName (){this.course.setName("French");}
        public void buildSchedule (){this.course.setSchedule("Tuesday 8:00 a.m - 11:00 a.m");}

        public void AddCost(){this.course.setCost(500);}


        public Course getCourse(){
            return course;
        }


}
