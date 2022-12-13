package com.babchikh.GestionEcoleAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babchikh.GestionEcoleAPI.model.Etudiant;
import com.babchikh.GestionEcoleAPI.service.EtudiantService;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

	private final EtudiantService etudiantService;
	
	public EtudiantController(EtudiantService etudiantService) {
		this.etudiantService = etudiantService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Etudiant>> getAllEtudiants(){
		List<Etudiant> etudiants = etudiantService.findAllEtudiants();
		return new ResponseEntity<>(etudiants, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Etudiant> getEtudiantById(@PathVariable("id") long id){
		Etudiant etudiant = etudiantService.findEtudiantById(id);
		return new ResponseEntity<>(etudiant, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant){
		Etudiant newEtudiant = etudiantService.addEtudiant(etudiant);
		return new ResponseEntity<>(newEtudiant, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant){
		Etudiant updateEtudiant = etudiantService.updateEtudiant(etudiant);
		return new ResponseEntity<>(updateEtudiant, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEtudiant(@PathVariable("id") long id){
		etudiantService.deleteEtudiant(id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
