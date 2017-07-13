package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity

public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(length = 6, unique = true)
	@NotNull
	private String numeroserie;

	@Column(length = 6, unique = true)
	@NotNull
	private String numeromotor;

	@NotNull
	private double preciofactura;

	@NotNull
	private int anio;

	private double impuesto;

	public Vehiculo() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroserie() {
		return numeroserie;
	}

	public void setNumeroserie(String numeroserie) {
		this.numeroserie = numeroserie;
	}

	public String getNumeromotor() {
		return numeromotor;
	}

	public void setNumeromotor(String numeromotor) {
		this.numeromotor = numeromotor;
	}

	public double getPreciofactura() {
		return preciofactura;
	}

	public void setPreciofactura(double preciofactura) {
		this.preciofactura = preciofactura;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

}
