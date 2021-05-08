package br.com.hrpayroll.services;

import br.com.hrpayroll.clients.WorkerClient;
import br.com.hrpayroll.entities.Payment;
import br.com.hrpayroll.vo.WorkerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private WorkerClient workerClient;

    @Value("${hr-worker.host}")
    private String workerHost;

    @Value("${hr-worker.path-get-workers}")
    private String pathGetWorkers;

    public Payment getPayment(long workerId, int days) {

        ResponseEntity<WorkerVO> responseWorkerVO = workerClient.findById(workerId);
        WorkerVO workerVO = responseWorkerVO.getBody();
        return new Payment(workerVO.getName(), workerVO.getDailyIncome(), days);
    }

}
