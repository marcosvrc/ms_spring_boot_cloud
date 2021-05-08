package br.com.hrpayroll.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class WorkerVO implements Serializable {

    private Long id;
    private String name;
    private Double dailyIncome;
}
