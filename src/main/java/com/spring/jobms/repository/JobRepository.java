package com.spring.jobms.repository;

import com.spring.jobms.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{

    List<Job> findByJobIdIn(List<Long> jobIds);
}
