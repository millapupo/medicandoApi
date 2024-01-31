package medicando.api.controller;

import medicando.api.domain.medicamentos.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

  @Autowired
  private MedicamentoRepository repository;
}




