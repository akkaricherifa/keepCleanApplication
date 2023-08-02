package com.example.keepcleanproxymapp.repository;


import com.example.keepcleanproxymapp.entities.admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<admin, Long> {
}
