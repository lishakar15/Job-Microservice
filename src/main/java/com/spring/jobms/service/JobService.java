package com.spring.jobms.service;

import com.spring.jobms.entity.Job;

import java.util.List;

public interface JobService {
    public List<Job> saveAllJobs(List<Job> jobs);

    public List<Job> getAllJobs();
    public List<Job> getJobsByIds(List<Long> jobIds);
}
