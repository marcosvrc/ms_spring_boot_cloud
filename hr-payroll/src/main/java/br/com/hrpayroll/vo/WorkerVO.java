package br.com.hrpayroll.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkerVO implements Serializable {

	private static final long serialVersionUID = 5407556080937497101L;
	
	private Long id;
    private String name;
	private Double dailyIncome;
}
