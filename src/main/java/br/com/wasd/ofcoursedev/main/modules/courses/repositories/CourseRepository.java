package br.com.wasd.ofcoursedev.main.modules.courses.repositories;

import br.com.wasd.ofcoursedev.main.modules.courses.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

    Optional<CourseEntity> findByName(String name);
    Optional<CourseEntity> findById(UUID id);
}
