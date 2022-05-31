package org.serratec.java2.borracharia.repository;

import java.util.List;

import org.serratec.java2.borracharia.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

	@Query(value="SELECT top 5 * FROM SERVICO order by data_servico desc", nativeQuery=true)
	List<Servico> buscarUltimosCincoServicos();
	
}
