package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.exception.IdNotFoundException;
import com.axis.model.Patient;
import com.axis.repository.PatientRepository;
import com.axis.util.AppConstant;
@Service

public class PatientServiceimpl implements PatientService {

	@Autowired
	public PatientRepository patientRepository;
	
	@Override
	public List<Patient> getAllPatients() {
		
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientById(int id) {
		Patient patient=patientRepository.findById(id).orElseThrow(()->new IdNotFoundException(AppConstant.IdNotFound));
		return patient;
	}

	@Override
	public Patient addPatient(Patient patient) {
		
		return patientRepository.save(patient);
	}

	@Override
	public Patient updatePatientById(int id, Patient patient) {
		
		Patient patient1=patientRepository.findById(id).orElseThrow(()->new IdNotFoundException(AppConstant.IdNotFound));
		patient1.setName(patient.getName());
		patient1.setAge(patient.getAge());
		patient1.setProblem(patient.getProblem());
		return patientRepository.save(patient1);
	}

	@Override
	public String deletePatient(int id) {
		Patient patient1=patientRepository.findById(id).orElseThrow(()->new IdNotFoundException(AppConstant.IdNotFound));
		// TODO Auto-generated method stub
		patientRepository.delete(patient1);
		return AppConstant.DeleteMessage;
	}

}
