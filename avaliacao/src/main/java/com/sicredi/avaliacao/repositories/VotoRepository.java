package com.sicredi.avaliacao.repositories;

import com.sicredi.avaliacao.models.Sessao;
import com.sicredi.avaliacao.models.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long>{
	
}
