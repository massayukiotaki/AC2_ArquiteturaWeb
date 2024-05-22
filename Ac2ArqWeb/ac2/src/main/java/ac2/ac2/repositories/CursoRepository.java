package ac2.ac2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ac2.ac2.models.Curso;
import ac2.ac2.models.Professor;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    //curso - professores
    @Query("select c from Curso c left join fetch c.professores c where p.id = :id ")
    List<Professor> findCursoProfessor(@Param("id") Long id);
}
