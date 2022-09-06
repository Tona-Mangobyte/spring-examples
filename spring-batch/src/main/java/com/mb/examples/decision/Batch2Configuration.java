package com.mb.examples.decision;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration
public class Batch2Configuration {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step startStep() {
        return stepBuilderFactory.get("startStep")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("This is the start tasklet");
                    return RepeatStatus.FINISHED;
                }).build();
    }
    @Bean
    public Step eventStep() {
        return stepBuilderFactory.get("eventStep")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("This is the event tasklet");
                    return RepeatStatus.FINISHED;
                }).build();
    }
    @Bean
    public Step oddStep() {
        return stepBuilderFactory.get("oddStep")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("This is the odd tasklet");
                    return RepeatStatus.FINISHED;
                }).build();
    }
    @Bean
    public JobExecutionDecider decider() {
        return new OddDecider();
    }
    @Bean
    public Job jobDecider() {
        return jobBuilderFactory.get("jobDecider")
                .start(startStep())
                .next(decider())
                .from(decider()).on("ODD").to(oddStep())
                .from(decider()).on("EVENT").to(eventStep())
                .from(oddStep()).on("*").to(decider())
                .from(decider()).on("ODD").to(oddStep())
                .from(decider()).on("EVENT").to(eventStep())
                .end()
                .build();
    }
    public static class OddDecider implements JobExecutionDecider {

        private int count = 0;

        @Override
        public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
            count++;
            if (count % 2 == 0) {
                return new FlowExecutionStatus("EVENT");
            } else {
                return new FlowExecutionStatus("ODD");
            }
        }
    }
}
