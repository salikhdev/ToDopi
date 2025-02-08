package uz.salikhdev.todoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.salikhdev.todoapi.entity.Todo;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByDeleteAtIsNull();

    Optional<Todo> findByIdAndDeleteAtIsNull(Long id);

}
