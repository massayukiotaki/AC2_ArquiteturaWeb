package ac2.ac2.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ac2.ac2.dtos.ProfessorDTO;
import ac2.ac2.models.Agenda;
import ac2.ac2.models.Professor;
import ac2.ac2.services.ProfessorService;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {
    private ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarProfessor(@RequestBody ProfessorDTO professorDTO) {
        Professor professor = professorDTO.toProfessor();
        professorService.cadastrarProfessor(professor);
    }

    @GetMapping()
    public List<Professor> listarTodos() {
        return professorService.listarProfessores();
    }
    
    @GetMapping("{id}")
    public List<Agenda> visualizarAgendaPorId(@PathVariable Long id) {
        return professorService.visualizarAgendaPorId(id);
    }

    
}

