package ac2.ac2.services;

import java.util.List;

import ac2.ac2.models.Agenda;
import ac2.ac2.models.Professor;

public interface ProfessorService {
    void cadastrarProfessor(Professor professor);
    List<Professor> listarProfessores();
    List<Agenda> visualizarAgendaPorId(Long idProfessor);
}