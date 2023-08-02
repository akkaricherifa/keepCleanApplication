package com.example.keepcleanproxymapp.repository;


import com.example.keepcleanproxymapp.entities.Ouvrier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOuvrierRepo extends JpaRepository<Ouvrier, Long> {
}
