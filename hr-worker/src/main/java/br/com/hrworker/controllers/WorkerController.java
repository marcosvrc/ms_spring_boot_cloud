package br.com.hrworker.controllers;

import br.com.hrworker.entities.Worker;
import br.com.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    private static Logger log = LoggerFactory.getLogger(WorkerController.class);

    @Value("${spring.datasource.url}")
    private String jwtSecret;

    @Autowired
    private Environment environment;

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        log.info(jwtSecret);
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable(name = "id") Long id) {
    	
        log.info("PORTA: " + environment.getProperty("local.server.port"));

        Optional<Worker> worker = repository.findById(id);
        return ResponseEntity.ok(worker.get());
    }

}
