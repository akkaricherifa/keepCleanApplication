package com.example.keepcleanproxymapp.repository;

import com.example.keepcleanproxymapp.entities.SocieteCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocieteClienteRepo extends JpaRepository<SocieteCliente, Long> {
}
