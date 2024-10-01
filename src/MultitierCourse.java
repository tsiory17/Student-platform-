public class MultitierCourse implements ICourse {
    Course course = new Course();

    public void buildName (){this.course.setName("Multi Tier Application");}
    public void buildSchedule (){this.course.setSchedule("Tuesday 2:00 p.m - 05:00 p.m");}

    public void AddCost(){this.course.setCost(1000);}


    public Course getCourse(){
        return course;
    }
}
