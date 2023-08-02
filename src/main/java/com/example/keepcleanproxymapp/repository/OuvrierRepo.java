package com.example.keepcleanproxymapp.repository;

import com.example.keepcleanproxymapp.entities.Ouvrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OuvrierRepo extends JpaRepository<Ouvrier, Long> {
}
