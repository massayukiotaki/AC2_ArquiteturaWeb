package ac2.ac2.dtos;

import ac2.ac2.models.Professor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessorDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String cidade;
    private String estado;
    private String cep;
    private String celular;

    public Professor toProfessor() {
        Professor professor = new Professor();
        professor.setId(this.id);
        professor.setNome(this.nome);
        professor.setCpf(this.cpf);
        professor.setRg(this.rg);
        professor.setCidade(this.cidade);
        professor.setEstado(this.estado);
        professor.setCep(this.cep);
        professor.setCelular(this.celular);
        return professor;
    }
}
