package br.com.wasd.ofcoursedev.main.modules.courses.erros;

public class CourseFoundError extends RuntimeException{

    private String message;

    public CourseFoundError(String message) {
        super(message);
    }
}
