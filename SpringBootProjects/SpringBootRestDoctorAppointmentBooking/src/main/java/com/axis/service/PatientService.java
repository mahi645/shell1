package com.axis.service;

import java.util.List;

import com.axis.model.Patient;

public interface PatientService {
	public List<Patient> getAllPatients();
	public Patient getPatientById(int id);
	public Patient addPatient(Patient patient);
	public Patient updatePatientById(int id,Patient patient);
	public String deletePatient(int id);

}
