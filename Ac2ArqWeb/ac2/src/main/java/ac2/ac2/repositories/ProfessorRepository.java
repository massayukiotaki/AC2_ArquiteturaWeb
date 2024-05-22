package ac2.ac2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ac2.ac2.models.Agenda;
import ac2.ac2.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    //professor agenda
    @Query("select p from Profesor p left join fetch p.agenda c where p.id = :id ")
    List<Agenda> findProfessorAgenda(@Param("id") Long id);
}

