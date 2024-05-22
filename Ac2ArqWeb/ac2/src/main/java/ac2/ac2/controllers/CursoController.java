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

import ac2.ac2.dtos.CursoDTO;
import ac2.ac2.models.Curso;
import ac2.ac2.services.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {
    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarCurso(@RequestBody CursoDTO cursoDTO) {
        Curso curso = cursoDTO.toCurso();
        cursoService.adicionarCurso(curso);
    }

    @GetMapping()
    public List<Curso> listarTodos() {
        return cursoService.listarCursos();
    }

    
    @GetMapping("{id}")
    public Curso buscarCursoPorId(@PathVariable Long id) {
        return cursoService.buscarCursoPorId(id);
    }
}

