package br.com.wasd.ofcoursedev.main.modules.courses.erros;

public class CourseNotFoundError extends RuntimeException{

    public CourseNotFoundError(String message) {
        super(message);
    }
}
