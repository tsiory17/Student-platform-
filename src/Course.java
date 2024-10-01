public class Course {
    private String name;
    private String schedule ;

    public double getGrades() {
        return grades;
    }

    public void setGrades(double grades) {
        this.grades = grades;
    }

    private double grades ;
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    private double cost ;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Course (){

    }

    public void DisplayCourse(){
        System.out.println("*Course name : "+getName()+"\n\t\t\t - schedule : "+getSchedule()+"\n");


    }

    public void DisplayGrades (){
        System.out.println("Course name : "+getName()+"\t Grades: "+getGrades()+"%");
    }

    public void DisplayCourseToCancel(){
        System.out.println(getName());
    }




}
