package com.spring.jobms.controller;

import com.spring.jobms.entity.Job;
import com.spring.jobms.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;
    private Logger LOGGER = LoggerFactory.getLogger(JobController.class);

    @PostMapping("/saveAllJobs")
    @ResponseBody
    public List<Job> saveAllJobs(@RequestBody List<Job> jobs)
    {
        return jobService.saveAllJobs(jobs);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody()
    @GetMapping("/healthCheck")
    public String healthCheck()
    {
        LOGGER.info("Health: Good");
        return "Health: good";
    }
    @GetMapping("/getAllJobs")
    @ResponseBody
    public List<Job> getAllJobs()
    {
        return jobService.getAllJobs();
    }
    @PostMapping("/getJobsByIds")
    public List<Job> getJobsByIds(@RequestBody List<Long>jobIds)
    {
        return jobService.getJobsByIds(jobIds);
    }


}
