import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Student {

    private String Name;
    private List<Course> AllCourses;

    public Student(String name, List<Course> allCourses) {
        Name = name;
        AllCourses = allCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", AllCourses=" + AllCourses +
                '}';
    }


    public String getName() {
        return Name;
    }

    public List<Course> getAllCourses() {
        return AllCourses;
    }

}
