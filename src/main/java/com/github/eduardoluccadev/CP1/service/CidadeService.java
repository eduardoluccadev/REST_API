package com.github.eduardoluccadev.CP1.service;

import com.github.eduardoluccadev.CP1.controller.dto.CidadeDTO;
import com.github.eduardoluccadev.CP1.entities.Cidade;
import com.github.eduardoluccadev.CP1.service.exceptions.ResourceNotFoundException;
import com.github.eduardoluccadev.CP1.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade salvar(CidadeDTO dto) {
        Cidade cidade = new Cidade(null, dto.nome(), dto.estado(), dto.uf());
        return cidadeRepository.save(cidade);
    }

    public List<Cidade> buscarTodas() {
        return cidadeRepository.findAll();
    }

    public Cidade buscarPorId(Long id) {
        return cidadeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada com o ID: " + id));
    }

    public Cidade atualizar(Long id, CidadeDTO dto) {
        Cidade cidade = buscarPorId(id); // Lança exceção se não encontrar
        cidade.setNome(dto.nome());
        cidade.setEstado(dto.estado());
        cidade.setUf(dto.uf());
        return cidadeRepository.save(cidade);
    }

    // Deletar uma cidade
    public void deletar(Long id) {
        Cidade cidade = buscarPorId(id);
        cidadeRepository.delete(cidade);
    }
}
