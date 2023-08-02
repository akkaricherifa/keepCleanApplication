package com.example.keepcleanproxymapp.repository;


import com.example.keepcleanproxymapp.entities.SocieteCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISocieteClienteRepo extends JpaRepository<SocieteCliente, Long> {
}
