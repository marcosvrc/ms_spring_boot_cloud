package br.com.hrpayroll.clients;

import br.com.hrpayroll.vo.WorkerVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerClient {

    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkerVO> findById(@PathVariable Long id);

}
