package ec.edu.espe.arquitectura.batch.process;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

@Slf4j
public class ReadAndInsertTask implements Tasklet, StepExecutionListener {

  public ReadAndInsertTask() {}

  @Override
  public void beforeStep(StepExecution arg0) {
    log.info("Leyendo archivo");
  }

  @Override
  public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {

    return RepeatStatus.FINISHED;
  }

  @Override
  public ExitStatus afterStep(StepExecution arg0) {
    return ExitStatus.COMPLETED;
  }
}
