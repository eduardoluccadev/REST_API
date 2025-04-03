package com.github.eduardoluccadev.CP1.repositories;

import com.github.eduardoluccadev.CP1.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}

