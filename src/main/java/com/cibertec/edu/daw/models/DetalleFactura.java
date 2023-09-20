package com.cibertec.edu.daw.models;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "Cliente")
@NoArgsConstructor
public class DetalleFactura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "detalle_id")
	Long id;
	
	@Column(name = "producto")
	String producto;
	
	@Column(name = "cantidad")
	int cantidad;
	
	@Column(name = "precioU")
	BigDecimal precioUnitario;
		
    @ManyToOne
    @JoinColumn(name = "factura_id")
    Factura factura;
}
