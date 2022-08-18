package ec.edu.espe.arquitectura.batch.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class BaseURLValues {
  private final String estudianteURL;

  private final String paraleloURL;

  public BaseURLValues(
      @Value("${colegio.base-url}") String estudianteURL,
      @Value("${colegio.base-url}") String paraleloURL) {
    this.estudianteURL = estudianteURL + "/estudiante";
    this.paraleloURL = paraleloURL + "/paralelo";
  }
}
