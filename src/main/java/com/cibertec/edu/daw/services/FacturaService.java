package com.cibertec.edu.daw.services;

import com.cibertec.edu.daw.models.Cliente;
import com.cibertec.edu.daw.models.Factura;
import com.cibertec.edu.daw.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {
    private final FacturaRepository facturaRepository;
    private final ClienteService clienteService;

    @Autowired
    public FacturaService(FacturaRepository facturaRepository, ClienteService clienteService) {
        this.facturaRepository = facturaRepository;
        this.clienteService = clienteService;
    }

    public List<Factura> obtenerTodasLasFacturas() {
        return (List<Factura>) facturaRepository.findAll();
    }

    public Factura obtenerFacturaPorId(Long id) {
        Optional<Factura> facturaOptional = facturaRepository.findById(id);
        if (facturaOptional.isPresent()) {
            return facturaOptional.get();
        } else {
            throw new RuntimeException("Factura no encontrada");
        }
    }

    public Factura crearFactura(Factura factura) {
        if (facturaRepository.existsByNumeroFactura(factura.getNumeroFactura())) {
            throw new RuntimeException("El número de factura ya está en uso.");
        }
        Cliente cliente = clienteService.obtenerClientePorId(factura.getCliente().getId());
        factura.setCliente(cliente);
        return facturaRepository.save(factura);
    }

}
