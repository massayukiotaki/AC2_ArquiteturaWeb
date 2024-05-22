package ac2.ac2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2.ac2.models.Agenda;
import ac2.ac2.repositories.AgendaRepository;
import ac2.ac2.exceptions.RegraNegocioException;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository agendaRepository;

    @Autowired
    public AgendaServiceImpl(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Override
    public Agenda adicionarAgenda(Agenda agenda) {
        // Validação e configuração dos dados da agenda antes de salvar
        Agenda novaAgenda = new Agenda();
        novaAgenda.setCurso(agenda.getCurso());
        novaAgenda.setConteudoCurso(agenda.getConteudoCurso());
        novaAgenda.setDataHoraInicio(agenda.getDataHoraInicio());
        novaAgenda.setDataHoraFim(agenda.getDataHoraFim());
        novaAgenda.setCidade(agenda.getCidade());
        novaAgenda.setEstado(agenda.getEstado());
        novaAgenda.setCep(agenda.getCep());
        novaAgenda.setProfessores(agenda.getProfessores());
        novaAgenda.setCursos(agenda.getCursos());

        return agendaRepository.save(novaAgenda);
    }

    @Override
    public List<Agenda> listarAgendas() {
        return agendaRepository.findAll();
    }

    @Override
    public Agenda buscarAgendaPorId(Long id) {
        return agendaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Agenda não encontrada com o ID fornecido"));
    }
}
