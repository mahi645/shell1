package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.axis.model.Patient;
import com.axis.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

	@Autowired
	public PatientService patientService;
	
	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getAllPatients(){
		List<Patient> patient=patientService.getAllPatients();
		return new ResponseEntity<List<Patient>>(patient,HttpStatus.OK);
	}
	@GetMapping("/patient/{id}")
	public ResponseEntity<Patient> getPatientById(int id) {
		Patient patient=patientService.getPatientById(id);
		return new ResponseEntity<Patient>(patient,HttpStatus.OK);
	}
	@PostMapping("/patient")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
		return new ResponseEntity<Patient>(patientService.addPatient(patient),HttpStatus.OK);
	}
	@PutMapping("/patient/{id}")
	public ResponseEntity<Patient> updatePatientById(@PathVariable int id,@RequestBody Patient patient){
		return new ResponseEntity<Patient>(patientService.updatePatientById(id, patient),HttpStatus.OK);
	}
	@DeleteMapping("/patient/{id}")
	public ResponseEntity<String> deletePatientById(@PathVariable int id){
		return new ResponseEntity<String>(patientService.deletePatient(id),HttpStatus.OK);
	}

}
