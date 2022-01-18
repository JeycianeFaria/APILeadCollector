package br.com.zup.LeadCollectorSecurity.usuario;

import br.com.zup.LeadCollectorSecurity.config.security.UsuarioLogado;
import br.com.zup.LeadCollectorSecurity.usuario.dtos.CadastroUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
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

    @PutMapping
    public void atualizarUsuario(@RequestBody CadastroUsuarioDTO usuarioRecebido, Authentication authentication){
        UsuarioLogado usuarioLogado = (UsuarioLogado) authentication.getPrincipal();
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioRecebido.getEmail());
        usuario.setSenha(usuarioRecebido.getSenha());

        usuarioService.atualizarUsuario(usuario, usuarioLogado.getId());
    }

}
