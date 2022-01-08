package br.com.zup.LeadCollectorSecurity.usuario;

import br.com.zup.LeadCollectorSecurity.usuario.dtos.CadastroUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarUsuario(@RequestBody CadastroUsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());

        usuarioService.salvarUsuario(usuario);
    }

}
