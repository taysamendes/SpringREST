package com.algaworks.osapi.domain.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.osapi.domain.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

//	List<Client> findByNome(String name);
//	List<Client> findByNomeContaining(String name);
	Client findByEmail(String email);

}
