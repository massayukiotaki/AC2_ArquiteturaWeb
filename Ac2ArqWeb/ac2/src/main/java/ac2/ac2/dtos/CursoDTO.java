package ac2.ac2.dtos;

import ac2.ac2.models.Curso;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoDTO {
    private Long id;
    private String descricao;
    private Integer cargaHoraria;
    private String objetivos;
    private String ementa;

    public Curso toCurso() {
        Curso curso = new Curso();
        curso.setId(this.id);
        curso.setDescricao(this.descricao);
        curso.setCargaHoraria(this.cargaHoraria);
        curso.setObjetivos(this.objetivos);
        curso.setEmenta(this.ementa);
        return curso;
    }
}
