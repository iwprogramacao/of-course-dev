package br.com.wasd.ofcoursedev.main.modules.courses.entities;

import br.com.wasd.ofcoursedev.main.modules.courses.enums.ActiveEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O campo [name] é obrigatório.")
    private String name;

    @NotBlank(message = "O campo [category] é obrigatório.")
    private String category;

    @NotNull(message = "O campo [active] é obrigatório.")
    @Enumerated(EnumType.STRING)
    private ActiveEnum active;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
