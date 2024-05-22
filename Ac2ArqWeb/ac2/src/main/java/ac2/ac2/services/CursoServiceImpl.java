package ac2.ac2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2.ac2.models.Curso;
import ac2.ac2.repositories.CursoRepository;
import ac2.ac2.exceptions.RegraNegocioException;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Curso adicionarCurso(Curso curso) {
        Curso novoCurso = new Curso();
        novoCurso.setDescricao(curso.getDescricao());
        novoCurso.setCargaHoraria(curso.getCargaHoraria());
        novoCurso.setObjetivos(curso.getObjetivos());
        novoCurso.setEmenta(curso.getEmenta());
        novoCurso.setAgendas(curso.getAgendas());
        novoCurso.setProfessores(curso.getProfessores());
        return cursoRepository.save(novoCurso);
    }

    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso buscarCursoPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Curso não encontrado com o ID fornecido"));
    }
}
