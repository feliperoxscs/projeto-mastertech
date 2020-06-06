package com.mastertech.sistemaponto.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import java.util.Optional;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mastertech.sistemaponto.model.Usuario;
import com.mastertech.sistemaponto.service.UsuarioService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UsuarioController.class)
public class UsuarioControllerTest{
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    private Usuario usuario = new Usuario();
    private String cpf = "456.678.876-00";
    private String nomeCompleto = "Jose da Silva Sauro";
    private String email =  "jose123@hotmail.com";
    private String dataCadastro = "05/05/2005";

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void prepare() {
        usuario = new Usuario();
        usuario.setCpf(cpf);
        usuario.setDataCadastro(dataCadastro);
        usuario.setEmail(email);
        usuario.setNomeCompleto(nomeCompleto);
    }
    
    @Test
    public void deveCriarUser() throws Exception {
        when(usuarioService.createUser(any(Usuario.class))).thenReturn(usuario);
        String request = mapper.writeValueAsString(usuario);
        mockMvc.perform(post("/usuario")
               .contentType(MediaType.APPLICATION_JSON_UTF8)           
               .content(request))
            .andExpect(status().isOk())
            .andExpect(content().string(request));
    }
}