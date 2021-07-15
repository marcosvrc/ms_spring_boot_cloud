package br.com.hr.oauth.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String roleName;

}
