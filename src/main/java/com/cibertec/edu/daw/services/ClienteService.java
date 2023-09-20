package com.cibertec.edu.daw.services;

import com.cibertec.edu.daw.models.Cliente;
import com.cibertec.edu.daw.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Cliente obtenerClientePorId(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }

    public Cliente crearCliente(Cliente cliente) {
        if (clienteRepository.existsByCorreoElectronico(cliente.getCorreoElectronico())) {
            throw new RuntimeException("El correo electrónico ya está en uso.");
        }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente actualizarCliente(Long id, Cliente cliente) {
        Cliente clienteExistente = obtenerClientePorId(id);
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setCorreoElectronico(cliente.getCorreoElectronico());
        return clienteRepository.save(clienteExistente);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}