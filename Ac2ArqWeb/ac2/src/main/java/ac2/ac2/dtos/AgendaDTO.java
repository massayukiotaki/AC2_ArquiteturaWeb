package ac2.ac2.dtos;

import java.time.LocalDateTime;

import ac2.ac2.models.Agenda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgendaDTO {
    private Long id;
    private String curso;
    private String conteudoCurso;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String professores;
    private String cidade;
    private String estado;
    private String cep;

    public Agenda toAgenda() {
        Agenda agenda = new Agenda();
        agenda.setId(this.id);
        agenda.setCurso(this.curso);
        agenda.setConteudoCurso(this.conteudoCurso);
        agenda.setDataHoraInicio(this.dataHoraInicio);
        agenda.setDataHoraFim(this.dataHoraFim);
        agenda.setCidade(this.cidade);
        agenda.setEstado(this.estado);
        agenda.setCep(this.cep);
        return agenda;
    }    
}
