public class InfoSystemCourse implements ICourse{
    Course course = new Course();

    public void buildName (){this.course.setName("Information System");}
    public void buildSchedule (){this.course.setSchedule("Monday 8:00 a.m - 11:00 a.m");}

    public void AddCost(){this.course.setCost(1000);}


    public Course getCourse(){
        return course;
    }
}
