package com.ex.mvcprac3.repository;

import com.ex.mvcprac3.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
