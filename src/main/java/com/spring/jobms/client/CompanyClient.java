package com.spring.jobms.client;

import com.spring.jobms.entity.Job;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name="companyms")
public interface CompanyClient {

    @PostMapping("/company/updateJobsInCompany")
    public ResponseEntity<String> updateJobIdsInCompanyService(List<Job> jobList);
    
}
