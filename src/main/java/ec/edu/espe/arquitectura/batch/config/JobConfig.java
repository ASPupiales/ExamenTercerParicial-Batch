package ec.edu.espe.arquitectura.batch.config;

import ec.edu.espe.arquitectura.batch.process.AssignStudentTask;
import ec.edu.espe.arquitectura.batch.process.GenerateListTask;
import ec.edu.espe.arquitectura.batch.process.ReadAndInsertTask;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
public class JobConfig {
  @Autowired private JobBuilderFactory jobs;

  @Autowired private StepBuilderFactory steps;

  @Bean
  protected Step readAndInsertTask() {
    return steps.get("readAndInsertTask").tasklet(new ReadAndInsertTask()).build();
  }

  @Bean
  protected Step assignStudentTask() {
    return steps.get("assignStudentTask").tasklet(new AssignStudentTask()).build();
  }

  @Bean
  protected Step generateListTask() {
    return steps.get("generateListTask").tasklet(new GenerateListTask()).build();
  }

  @Bean
  public Job processTextFileJob() {
    return jobs.get("processTextFileJob")
        .start(readAndInsertTask())
        .next(assignStudentTask())
        .next(generateListTask())
        .build();
  }
}
