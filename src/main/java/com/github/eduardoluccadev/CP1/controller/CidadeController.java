package com.github.eduardoluccadev.CP1.controller;

import com.github.eduardoluccadev.CP1.controller.dto.CidadeDTO;
import com.github.eduardoluccadev.CP1.entities.Cidade;
import com.github.eduardoluccadev.CP1.service.CidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<Cidade> criarCidade(@Valid @RequestBody CidadeDTO dto) {
        Cidade novaCidade = cidadeService.salvar(dto);
        return ResponseEntity.ok(novaCidade);
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> listarCidades() {
        List<Cidade> cidades = cidadeService.buscarTodas();
        return ResponseEntity.ok(cidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> buscarCidadePorId(@PathVariable Long id) {
        Cidade cidade = cidadeService.buscarPorId(id);
        return ResponseEntity.ok(cidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> atualizarCidade(@PathVariable Long id, @Valid @RequestBody CidadeDTO dto) {
        Cidade cidadeAtualizada = cidadeService.atualizar(id, dto);
        return ResponseEntity.ok(cidadeAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCidade(@PathVariable Long id) {
        cidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

