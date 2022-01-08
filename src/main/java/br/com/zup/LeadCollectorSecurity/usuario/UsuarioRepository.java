package br.com.zup.LeadCollectorSecurity.usuario;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UsuarioRepository extends CrudRepository<Usuario, UUID> {

}
