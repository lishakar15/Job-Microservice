package com.spring.jobms.controller;

import com.spring.jobms.client.CompanyClient;
import com.spring.jobms.entity.Job;
import com.spring.jobms.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;
    @Autowired
    private CompanyClient companyClient;
    private Logger  LOGGER = LoggerFactory.getLogger(JobController.class);

    @PostMapping("/saveAllJobs")
    public ResponseEntity<String> saveAllJobs(@RequestBody List<Job> jobs)
    {
        List<Job> jobList = jobService.saveAllJobs(jobs);
        if(jobList != null && jobList.isEmpty())
        {
            //Feign Client to call Company Microservice
            ResponseEntity<String> companyResponse = companyClient.updateJobIdsInCompanyService(jobList);
            if(companyResponse.getStatusCode().equals(HttpStatus.OK))
                LOGGER.info("Job details updated successfully to Companies");
        }
        return new ResponseEntity<>("Saved Successfully",HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)

    @GetMapping("/healthCheck")
    public String healthCheck()
    {
        LOGGER.info("Health: Good from JOB 1");
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
