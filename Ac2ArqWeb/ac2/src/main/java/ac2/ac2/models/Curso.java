package ac2.ac2.models;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Integer cargaHoraria;
    @Column(nullable = false)
    private String objetivos;
    @Column(nullable = false)
    private String ementa;

    @OneToMany(mappedBy = "Curso")
    private List<Agenda> agendas;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "curso_professor", joinColumns =  @JoinColumn(name = "id"),
    inverseJoinColumns = @JoinColumn(name = "professorId"))
    private List<Professor> professores;

    @Override
    public String toString(){
        return "Curso [id]=" + id + ", descrição=" + descricao + 
        ", carga horária=" + cargaHoraria + ", objetivos=" + objetivos + ", ementa=" + ementa + "]";
    }
}
