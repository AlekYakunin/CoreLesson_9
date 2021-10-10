import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static javafx.scene.input.KeyCode.T;

public class Main {

    public static void main(String[] args) {

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Вводный курс студента"));
        courses.add(new Course("Java. Уровень 1"));
        courses.add(new Course("Java Core для тестировщиков"));
        courses.add(new Course("Тестирование мобильных приложений"));
        courses.add(new Course("Git. Базовый курс"));
        courses.add(new Course("Основы ООП"));
        courses.add(new Course("C#. Быстрый старт"));
        courses.add(new Course("Основы программирования"));
        courses.add(new Course("Английский для IT-специалистов"));
        courses.add(new Course("Основы Jira и Confluence"));
        courses.add(new Course("Проектирование БД и запросы SQL"));
        courses.add(new Course("Основы тестирования ПО"));
        courses.add(new Course("Компьютерные сети"));
        courses.add(new Course("Основы вёрстки для веб-дизайнера"));

        List<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student("Ivanov", courses.subList(0,3)));
        studentsList.add(new Student("Petrov", courses.subList(3,8)));

        List<Course> personCourses = new ArrayList<>();
        personCourses.add(new Course(courses.get(1).getCourseName()));
        personCourses.add(new Course(courses.get(3).getCourseName()));
        personCourses.add(new Course(courses.get(5).getCourseName()));
        personCourses.add(new Course(courses.get(7).getCourseName()));
        studentsList.add(new Student("Sidorov", personCourses));

        studentsList.add(new Student("Sokolov", courses.subList(4,9)));



        // Уникальные курсы
        String course = studentsList.stream()
                .flatMap(a -> Stream.of(a))
                .map(Student::getAllCourses)
                .collect(Collectors.toSet()).toString();

        course = course.replace("[", "");
        course = course.replace("]", "");
        String[] courseArray = course.split(",");

        Stream.of(courseArray)
                .distinct()
                .forEach(p -> System.out.println(p));

        System.out.println();

        // число курсов сортированное
        System.out.println("Трое 'любознательных'");

        studentsList.stream()
                .filter( Course.distinctByKey(Student::getAllCourses))
                .sorted((p1, p2) -> p2.getAllCourses().size() - p1.getAllCourses().size())
                .limit(3)
                .forEach(System.out::println);

        System.out.println();

        // по курсу
        System.out.println("по курсу 'Тестирование мобильных приложений'");

        Course courseName = new Course("Тестирование мобильных приложений");
        studentsList.stream()
                .filter(p -> p.getAllCourses().contains(courseName))
                .forEach(System.out::println);
    }


}
