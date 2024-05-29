package com.spring.jobms.rabbitmq;

import com.spring.jobms.dto.JobMessage;
import com.spring.jobms.entity.Job;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobMessageProducer {
    @Autowired
    public RabbitTemplate rabbitTemplate;

    public void sendJobMessage(List<Job> jobList)
    {
        List<JobMessage> jobMessageList = new ArrayList<>();
        for(Job job: jobList)
        {
        JobMessage jobMessage = new JobMessage();
        jobMessage.setJobId(job.getJobId());
        jobMessage.setCompanyId(job.getCompanyId());
        jobMessageList.add(jobMessage);
        }
        rabbitTemplate.convertAndSend("companyJobQueue",jobMessageList);
    }
}
