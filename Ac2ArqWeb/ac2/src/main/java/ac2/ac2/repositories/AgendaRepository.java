package ac2.ac2.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ac2.ac2.models.Agenda;
import ac2.ac2.models.Professor;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    //idprofessor e datas
        @Query("select p from Professor where p.dataHoraInicio between p.dataHoraInicio and p.dataHoraFim")
        Professor findCursoData(@Param("dataHoraInicio") LocalDateTime dataHoraInicio,
                                @Param("dataHoraFim") LocalDateTime dataHoraFim);
}
