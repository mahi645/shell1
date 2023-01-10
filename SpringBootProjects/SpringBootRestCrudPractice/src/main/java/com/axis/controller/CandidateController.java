package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.exception.ResourceNotFoundException;
import com.axis.model.Candidate;
import com.axis.repository.CandidateRepository;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
	@Autowired
	private CandidateRepository candidateRepository;
	//get all candidates
	@GetMapping
	public List<Candidate> getAllCandidates(){
		return this.candidateRepository.findAll();
	}
	//get candidate by id
	@GetMapping("/{id}")
	public Candidate getCandidateById(@PathVariable(value="id")long candidateId ) {
		return this.candidateRepository.findById(candidateId)
				.orElseThrow(()->new ResourceNotFoundException("user not found :"+candidateId));
	}
	@PostMapping
	public Candidate createCandidate(@RequestBody Candidate candidate) {
		return this.candidateRepository.save(candidate);
		
	}
	
	@PutMapping
	public Candidate updateCandidate(@RequestBody Candidate candidate,@PathVariable("id") long candidateId) {
		Candidate existing=this.candidateRepository.findById(candidateId)
				.orElseThrow(()->new ResourceNotFoundException("user not found :"+candidateId));
		existing.setName(candidate.getName());
		existing.setDept(candidate.getDept());
		existing.setGender(candidate.getGender());
		return this.candidateRepository.save(existing);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Candidate> deleteCandidate(@PathVariable("id") long candidateId){
		Candidate existing=this.candidateRepository.findById(candidateId)
				.orElseThrow(()->new ResourceNotFoundException("user not found :"+candidateId));
		this.candidateRepository.delete(existing);
		return ResponseEntity.ok().build();
		
	}
	//create candidate
	//update candidate by id
	//delete candidate by id
	

}
