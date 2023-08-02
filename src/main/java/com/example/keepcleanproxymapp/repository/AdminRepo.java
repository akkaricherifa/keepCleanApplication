package com.example.keepcleanproxymapp.repository;


import com.example.keepcleanproxymapp.entities.admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<admin, Long>  {
}
