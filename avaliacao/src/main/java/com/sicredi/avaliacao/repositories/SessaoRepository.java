package com.sicredi.avaliacao.repositories;

import com.sicredi.avaliacao.models.Pauta;
import com.sicredi.avaliacao.models.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoRepository extends JpaRepository<Sessao, Long>{
	
}
