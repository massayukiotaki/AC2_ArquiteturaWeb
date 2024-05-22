package ac2.ac2.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String curso;
    @Column(nullable = false)
    private String conteudoCurso;
    @Column(nullable = false)
    private LocalDateTime dataHoraInicio;
    @Column(nullable = false)
    private LocalDateTime dataHoraFim;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String cep;

    @ManyToOne
    @JoinColumn(name = "id")
    private Professor professores;

    @ManyToOne
    @JoinColumn(name = "id")
    private Curso cursos;

}
