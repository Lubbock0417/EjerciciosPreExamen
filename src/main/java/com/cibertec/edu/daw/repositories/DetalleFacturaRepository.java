package com.cibertec.edu.daw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cibertec.edu.daw.models.DetalleFactura;

public interface DetalleFacturaRepository extends CrudRepository<DetalleFactura, Long> {

    // Método para buscar los detalles de una factura por su número
    List<DetalleFactura> findByFacturaId(Long facturaId);
}
