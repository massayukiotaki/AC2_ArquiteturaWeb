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

import ac2.ac2.dtos.AgendaDTO;
import ac2.ac2.models.Agenda;
import ac2.ac2.services.AgendaService;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {
    private AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarAgenda(@RequestBody AgendaDTO agendaDTO) {
        Agenda agenda = agendaDTO.toAgenda();
        agendaService.adicionarAgenda(agenda);
    }

    @GetMapping()
    public List<Agenda> listarTodos() {
        return agendaService.listarAgendas();
    }
    
    @GetMapping("{id}")
    public Agenda buscarAgendaPorId(@PathVariable Long id) {
        return agendaService.buscarAgendaPorId(id);
    }

}

