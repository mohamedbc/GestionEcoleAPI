package com.babchikh.GestionEcoleAPI.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babchikh.GestionEcoleAPI.exception.UserNotFoundException;
import com.babchikh.GestionEcoleAPI.model.Etudiant;
import com.babchikh.GestionEcoleAPI.repository.EtudiantRepository;

@Service
public class EtudiantService {

	private final EtudiantRepository etudiantRepository;

	@Autowired
	public EtudiantService(EtudiantRepository etudiantRepository) {
		this.etudiantRepository = etudiantRepository;
	}
	
	public Etudiant addEtudiant(Etudiant etudiant) {
		etudiant.setCode(UUID.randomUUID().toString());
		return etudiantRepository.save(etudiant);
	}
	
	public List<Etudiant> findAllEtudiants(){
		return etudiantRepository.findAll();
	}
	
	public Etudiant updateEtudiant(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}
	
	public Etudiant findEtudiantById(long id) {
		return etudiantRepository.findEtudiantById(id)
				.orElseThrow(() -> new UserNotFoundException("Utilisateur qui port l'id "+id+" n'existe pas !"));
	}
	
	public void deleteEtudiant(long id) {
		etudiantRepository.deleteEtudiantById(id);
	}
	
}
