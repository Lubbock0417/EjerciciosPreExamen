package com.cibertec.edu.daw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cibertec.edu.daw.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    // Método para buscar un cliente por correo electrónico
    Cliente findByCorreoElectronico(String correoElectronico);

    // Método para verificar que un correo electrónico sea único
    boolean existsByCorreoElectronico(String correoElectronico);
}