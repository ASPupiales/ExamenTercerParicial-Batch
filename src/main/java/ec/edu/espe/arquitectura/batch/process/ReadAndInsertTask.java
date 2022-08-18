package ec.edu.espe.arquitectura.batch.process;

import ec.edu.espe.arquitectura.batch.config.BaseURLValues;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class ReadAndInsertTask {

  private final RestTemplate restTemplate;
  private final BaseURLValues baseURLs;
}
