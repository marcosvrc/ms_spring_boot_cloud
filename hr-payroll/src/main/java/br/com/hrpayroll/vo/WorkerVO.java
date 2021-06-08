package br.com.hrpayroll.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class WorkerVO implements Serializable {

	private static final long serialVersionUID = 5407556080937497101L;
	
	private Long id;
    private String name;
    private Double dailyIncome;
}
