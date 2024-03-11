package br.com.wasd.ofcoursedev.main.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {
    private String message;
    private String field;
}
