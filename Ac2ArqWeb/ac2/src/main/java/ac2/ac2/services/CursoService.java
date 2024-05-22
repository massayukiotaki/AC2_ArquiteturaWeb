package ac2.ac2.services;

import java.util.List;

import ac2.ac2.models.Curso;

public interface CursoService {
    Curso adicionarCurso(Curso curso);
    List<Curso> listarCursos();
    Curso buscarCursoPorId(Long id);
}
