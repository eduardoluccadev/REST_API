package com.github.eduardoluccadev.CP1.service;

import com.github.eduardoluccadev.CP1.controller.dto.EventoDTO;
import com.github.eduardoluccadev.CP1.entities.Cidade;
import com.github.eduardoluccadev.CP1.entities.Evento;
import com.github.eduardoluccadev.CP1.service.exceptions.ResourceNotFoundException;
import com.github.eduardoluccadev.CP1.repositories.CidadeRepository;
import com.github.eduardoluccadev.CP1.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public Evento salvar(EventoDTO dto) {
        Cidade cidade = cidadeRepository.findById(dto.cidadeId())
                .orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada com o ID: " + dto.cidadeId()));

        Evento evento = new Evento(null, dto.nome(), dto.url(), dto.data(), cidade);
        return eventoRepository.save(evento);
    }

    public List<Evento> buscarTodos() {
        return eventoRepository.findAll();
    }

    public Evento buscarPorId(Long id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com o ID: " + id));
    }

    public Evento atualizar(Long id, EventoDTO dto) {
        Evento evento = buscarPorId(id);
        Cidade cidade = cidadeRepository.findById(dto.cidadeId())
                .orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada com o ID: " + dto.cidadeId()));

        evento.setNome(dto.nome());
        evento.setUrl(dto.url());
        evento.setData(dto.data());
        evento.setCidade(cidade);
        return eventoRepository.save(evento);
    }

    public void deletar(Long id) {
        Evento evento = buscarPorId(id);
        eventoRepository.delete(evento);
    }
}

