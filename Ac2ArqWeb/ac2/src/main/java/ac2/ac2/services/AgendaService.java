package ac2.ac2.services;

import java.util.List;

import ac2.ac2.models.Agenda;

public interface AgendaService {
    Agenda adicionarAgenda(Agenda agenda);
    List<Agenda> listarAgendas();
    Agenda buscarAgendaPorId(Long id);
}
