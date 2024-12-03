package com.networkservicehub.client.repository;

import com.networkservicehub.client.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
