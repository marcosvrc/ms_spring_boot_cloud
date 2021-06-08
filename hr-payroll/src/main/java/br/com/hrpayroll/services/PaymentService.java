package br.com.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.hrpayroll.clients.WorkerClient;
import br.com.hrpayroll.entities.Payment;
import br.com.hrpayroll.vo.WorkerVO;

@Service
public class PaymentService {

    @Autowired
    private WorkerClient workerClient;	

    public Payment getPayment(long workerId, int days) {

        ResponseEntity<WorkerVO> responseWorkerVO = workerClient.findById(workerId);
        WorkerVO workerVO = responseWorkerVO.getBody();
        return new Payment(workerVO.getName(), workerVO.getDailyIncome(), days);
    }

}
