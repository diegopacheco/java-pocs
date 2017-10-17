package com.blogspot.diegopacheco.spring3.formatannotation;

import java.math.BigDecimal;

import javax.validation.Validator;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;

@Controller("moedaBR")
public class MoedaBR {

	@NumberFormat(pattern="###.###,00")
	private BigDecimal valor;
	
	@Size(max=6)
	private String pais;	
	
	@Autowired
    private Validator validator;

	public MoedaBR() {
	}

	public MoedaBR(BigDecimal valor) {
		super();
		this.valor = valor;
	}

	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

	public Validator getValidator() {
		return validator;
	}
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	public void validate(){
		validator.validate(this);
	}

}
