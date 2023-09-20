package com.cibertec.edu.daw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cibertec.edu.daw.models.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Long> {

    // Método para buscar una factura por número
    Factura findByNumeroFactura(String numeroFactura);

    // Método para verificar que un número de factura sea único
    boolean existsByNumeroFactura(String numeroFactura);
}
