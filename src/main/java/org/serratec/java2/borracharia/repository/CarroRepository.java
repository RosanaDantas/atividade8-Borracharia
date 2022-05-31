package org.serratec.java2.borracharia.repository;

import org.serratec.java2.borracharia.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer>{

}
