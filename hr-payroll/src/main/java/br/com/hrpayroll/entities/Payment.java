package br.com.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Payment implements Serializable {

	private static final long serialVersionUID = 1368343902697355189L;
	
	private String name;
    private Double dailyInCome;
    private Integer days;

    public double getTotal(){
        return this.days * this.dailyInCome;
    }
}
