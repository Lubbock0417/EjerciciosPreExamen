package com.cibertec.edu.daw.models;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Entity
@Table(name = "Factura")
@NoArgsConstructor
public class Factura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "factura_id")
	Long id;
	
	@Column(name = "factura_numero")
	String numeroFactura;
	
	@Column(name = "factura_fecha")
	LocalDate fechaEmision;
	
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    Cliente cliente;
}