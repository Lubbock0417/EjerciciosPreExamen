package com.cibertec.edu.daw.services;

import com.cibertec.edu.daw.models.DetalleFactura;
import com.cibertec.edu.daw.repositories.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaService {
    private final DetalleFacturaRepository detalleFacturaRepository;
    private final FacturaService facturaService;

    @Autowired
    public DetalleFacturaService(DetalleFacturaRepository detalleFacturaRepository, FacturaService facturaService) {
        this.detalleFacturaRepository = detalleFacturaRepository;
        this.facturaService = facturaService;
    }

    public List<DetalleFactura> obtenerDetallesPorFacturaId(Long facturaId) {
        return detalleFacturaRepository.findByFacturaId(facturaId);
    }

    public DetalleFactura crearDetalleFactura(DetalleFactura detalleFactura) {
        // Verificar que la factura exista
        facturaService.obtenerFacturaPorId(detalleFactura.getFactura().getId());
        return detalleFacturaRepository.save(detalleFactura);
    }

}