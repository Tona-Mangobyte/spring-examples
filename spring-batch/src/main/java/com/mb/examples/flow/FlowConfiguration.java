package com.mb.examples.flow;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration
public class FlowConfiguration {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("flow1")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("step1 from inside flow foo");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("flow2")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("step2 from inside flow foo");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Flow flow() {
        FlowBuilder<Flow> flowBuilder = new FlowBuilder<>("foo");
        flowBuilder.start(step1())
                .next(step2())
                .end();
        return flowBuilder.build();
    }
}
