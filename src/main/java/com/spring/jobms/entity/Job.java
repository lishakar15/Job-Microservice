package com.spring.jobms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
        @Id
        @SequenceGenerator(name = "job_seq",sequenceName = "job_seq", initialValue = 100,allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "job_seq")
        private Long jobId;
        private String description;
        private Long companyId;
}
