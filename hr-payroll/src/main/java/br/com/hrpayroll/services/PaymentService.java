package br.com.hrpayroll.services;

import br.com.hrpayroll.entities.Payment;
import br.com.hrpayroll.vo.WorkerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String workerHost;

    @Value("${hr-worker.path-get-workers}")
    private String pathGetWorkers;

    public Payment getPayment(long workerId, int days) {

        Map<String,String> mapParameters = new HashMap<>();
        mapParameters.put("id", Long.toString(workerId));

        WorkerVO workerVO = restTemplate.getForObject(workerHost + pathGetWorkers, WorkerVO.class, mapParameters);

        return new Payment(workerVO.getName(), workerVO.getDailyIncome(), days);
    }

}
