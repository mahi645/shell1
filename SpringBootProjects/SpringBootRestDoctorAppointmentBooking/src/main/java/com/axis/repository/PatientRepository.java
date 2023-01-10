package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.model.Patient;

public interface PatientRepository extends JpaRepository <Patient,Integer>{

}
