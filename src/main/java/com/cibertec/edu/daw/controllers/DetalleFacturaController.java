package com.cibertec.edu.daw.controllers;

import com.cibertec.edu.daw.models.DetalleFactura;
import com.cibertec.edu.daw.services.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas/{facturaId}/detalles")
public class DetalleFacturaController {
    private final DetalleFacturaService detalleFacturaService;

    @Autowired
    public DetalleFacturaController(DetalleFacturaService detalleFacturaService) {
        this.detalleFacturaService = detalleFacturaService;
    }

    @GetMapping
    public ResponseEntity<List<DetalleFactura>> obtenerDetallesPorFacturaId(@PathVariable Long facturaId) {
        List<DetalleFactura> detalles = detalleFacturaService.obtenerDetallesPorFacturaId(facturaId);
        return ResponseEntity.ok(detalles);
    }

    @PostMapping
    public ResponseEntity<DetalleFactura> crearDetalleFactura(@PathVariable Long facturaId, @RequestBody DetalleFactura detalleFactura) {
        detalleFactura.getFactura().setId(facturaId);
        DetalleFactura nuevoDetalle = detalleFacturaService.crearDetalleFactura(detalleFactura);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDetalle);
    }

    // Implementa más rutas y métodos según tus necesidades
}