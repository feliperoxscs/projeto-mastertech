package com.mastertech.sistemaponto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import com.mastertech.sistemaponto.model.Usuario;
import com.mastertech.sistemaponto.repository.UsuarioRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = UsuarioService.class)
public class UsuarioServiceTest {

    @Autowired
    private UsuarioService sujeito;

    @MockBean
    private UsuarioRepository usuarioRepository;

    
    private Usuario usuario;
    private List<Usuario> usuarios;
    private String cpf = "123.123.123-12";
    private String nomeCompleto = "José da Silva Sauro";
    private String email = "jose123@hotmail.com";
    private String dataCadastro = "05/05/2005";

    @Before
    public void prepare() {
        usuario = new Usuario();
        usuario.setCpf(cpf);
        usuario.setEmail(email);
        usuario.setNomeCompleto(nomeCompleto);
        usuario.setDataCadastro(dataCadastro);
    }

    @Test
    public void deveCriarUsuario() {
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario usuarioCriado = sujeito.createUser(usuario);
        assertEquals(usuario.getNomeCompleto(), usuarioCriado.getNomeCompleto());
        assertEquals(usuario.getCpf(), usuarioCriado.getCpf());
        assertEquals(usuario.getEmail(), usuarioCriado.getEmail());
        assertEquals(usuario.getDataCadastro(), usuarioCriado.getDataCadastro());
    }

    @Test
    public void deveBuscarUsuarioId() {
        long id = 3;
        usuario.setId(id);
        when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuario));

        Optional<Usuario> optional = sujeito.getUserById(id);
        assertEquals(usuario, optional.get());
    }

    @Test
    public void deveListarTodosUsuarios() {
        when(usuarioRepository.findAll()).thenReturn(usuarios);

        List<Usuario> testes = sujeito.getUsers();
        assertEquals(usuarios,testes);
    }   

    @Test
    public void deveEditarUsuario(){
        long id = 1;
        usuario.setId(id);
        when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuario));
        Usuario newUsuario = new Usuario();
        newUsuario.setCpf(cpf);
        newUsuario.setEmail(email);
        newUsuario.setNomeCompleto(nomeCompleto);
        ResponseEntity<Usuario> response = sujeito.changeUser(id, newUsuario);
        assertEquals(usuario, response.getBody());
    }
}