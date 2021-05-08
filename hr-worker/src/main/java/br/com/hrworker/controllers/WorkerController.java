package br.com.hrworker.controllers;

import br.com.hrworker.entities.Worker;
import br.com.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable(name = "id") Long id) {
        Optional<Worker> worker = repository.findById(id);
        return ResponseEntity.ok(worker.get());

    }

}
