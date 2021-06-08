package br.com.hrworker.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hrworker.entities.Worker;
import br.com.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    private static Logger log = LoggerFactory.getLogger(WorkerController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
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
