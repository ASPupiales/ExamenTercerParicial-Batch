package ec.edu.espe.arquitectura.batch.config;

import ec.edu.espe.arquitectura.batch.model.Estudiante;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.stereotype.Component;

@Component
public class CustomReader extends FlatFileItemReader<Estudiante> {
  public CustomReader() {
    setLinesToSkip(1);
    setLineMapper(getDefaultLineMapper());
  }

  public DefaultLineMapper<Estudiante> getDefaultLineMapper() {
    DefaultLineMapper<Estudiante> defaultLineMapper = new DefaultLineMapper<>();

    DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
    delimitedLineTokenizer.setNames(new String[] {"cedula", "nombres", "apellidos", "nivel"});
    defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);

    BeanWrapperFieldSetMapper<Estudiante> beanWrapperFieldSetMapper =
        new BeanWrapperFieldSetMapper<>();
    beanWrapperFieldSetMapper.setTargetType(Estudiante.class);
    defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

    return defaultLineMapper;
  }
}
