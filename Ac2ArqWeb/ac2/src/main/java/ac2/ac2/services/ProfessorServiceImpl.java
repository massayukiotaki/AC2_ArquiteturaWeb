package ac2.ac2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2.ac2.models.Agenda;
import ac2.ac2.models.Professor;
import ac2.ac2.repositories.ProfessorRepository;
import ac2.ac2.exceptions.RegraNegocioException;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public void cadastrarProfessor(Professor professor) {
        Professor novoProfessor = new Professor();
        novoProfessor.setNome(professor.getNome());
        novoProfessor.setCpf(professor.getCpf());
        novoProfessor.setRg(professor.getRg());
        novoProfessor.setCidade(professor.getCidade());
        novoProfessor.setEstado(professor.getEstado());
        novoProfessor.setCep(professor.getCep());
        novoProfessor.setCelular(professor.getCelular());
        novoProfessor.setCursos(professor.getCursos());
        novoProfessor.setAgendas(professor.getAgendas());
        
        professorRepository.save(novoProfessor);
    }

    @Override
    public List<Professor> listarProfessores() {
        return professorRepository.findAll();
    }

    @Override
    public List<Agenda> visualizarAgendaPorId(Long idProfessor) {
        Professor professor = professorRepository.findById(idProfessor)
                .orElseThrow(() -> new RegraNegocioException("Professor não encontrado com o ID fornecido"));
        return professor.getAgendas();
    }
}
