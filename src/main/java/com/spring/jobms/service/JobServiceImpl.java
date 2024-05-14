package com.spring.jobms.service;

import com.spring.jobms.entity.Job;
import com.spring.jobms.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;
    @Override
    public List<Job> saveAllJobs(List<Job> jobs) {

        return jobRepository.saveAll(jobs);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public List<Job> getJobsByIds(List<Long> jobIds) {
        return jobRepository.findByJobIdIn(jobIds);
    }
}
