package ec.edu.espe.arquitectura.batch.process;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class GenerateListTask implements Tasklet, StepExecutionListener {

  @Override
  public void beforeStep(StepExecution arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
    // TODO Auto-generated method stub
    return RepeatStatus.FINISHED;
  }

  @Override
  public ExitStatus afterStep(StepExecution arg0) {
    // TODO Auto-generated method stub
    return ExitStatus.COMPLETED;
  }
}
