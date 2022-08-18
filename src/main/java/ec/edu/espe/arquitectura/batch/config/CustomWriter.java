package ec.edu.espe.arquitectura.batch.config;

import ec.edu.espe.arquitectura.batch.model.Estudiante;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class CustomWriter extends FlatFileItemWriter<Estudiante> {

  private Resource outputResource =
      new FileSystemResource("src/main/resources/output/listadoNivel.txt");

  public CustomWriter() {
    setResource(this.outputResource);
    setAppendAllowed(true);
    setLineAggregator(getDelimitedLineAggregator());
  }

  public DelimitedLineAggregator<Estudiante> getDelimitedLineAggregator() {
    DelimitedLineAggregator<Estudiante> defaulDelimitedLineAggregator =
        new DelimitedLineAggregator<>();
    defaulDelimitedLineAggregator.setDelimiter(",");

    BeanWrapperFieldExtractor<Estudiante> beanWrapperFieldExtractor =
        new BeanWrapperFieldExtractor<>();
    beanWrapperFieldExtractor.setNames(new String[] {"cedula", "nombres", "apellidos", "nivel"});
    defaulDelimitedLineAggregator.setFieldExtractor(beanWrapperFieldExtractor);

    return defaulDelimitedLineAggregator;
  }
}
