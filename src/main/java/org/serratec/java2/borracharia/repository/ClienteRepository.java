package org.serratec.java2.borracharia.repository;

import org.serratec.java2.borracharia.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	

}
