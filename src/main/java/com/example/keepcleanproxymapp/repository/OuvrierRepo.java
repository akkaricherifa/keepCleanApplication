package com.example.keepcleanproxymapp.repository;

import com.example.keepcleanproxymapp.entities.Ouvrier;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface OuvrierRepo extends JpaRepository<Ouvrier, Long> {
    boolean existsByName(String name);

    boolean existsByEmail(String email);

    boolean existsByTel(Long tel);

    @NotNull

    Optional<Ouvrier> findById(@NotNull Long id);

    Ouvrier findByName(String name);
}
