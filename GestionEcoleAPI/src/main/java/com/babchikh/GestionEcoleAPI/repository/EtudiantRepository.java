package com.babchikh.GestionEcoleAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.babchikh.GestionEcoleAPI.model.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	void deleteEtudiantById(long id);

	Optional<Etudiant> findEtudiantById(long id);

}
