public class CourseCreator {

    ICourse icourse;

    CourseCreator(ICourse icourse){
        this.icourse=icourse;
    }

    void CreateCourse(){
        this.icourse.buildName();
        this.icourse.buildSchedule();
        this.icourse.AddCost();
    }
    Course getCourse(){
        return  this.icourse.getCourse();
    }
}
