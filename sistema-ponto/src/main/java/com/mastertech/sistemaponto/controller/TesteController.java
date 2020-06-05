package com.mastertech.sistemaponto.controller;

import java.util.List;

import com.mastertech.sistemaponto.model.Usuario;
import com.mastertech.sistemaponto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ThisWillActuallyRun {

    @Autowired
    private UsuarioService usuarioService;


    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public List<Usuario> getAllUsers() {
        return usuarioService.getUsers();
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET )
    public ResponseEntity<Usuario> getById(@PathVariable(value = "id") long id){
        return usuarioService.getUserById(id);
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public Usuario createUser(@RequestBody Usuario usuario){
        return usuarioService.createUser(usuario);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Usuario> changeUser(@PathVariable(value = "id") long id, @RequestBody Usuario newUsuario){
        return usuarioService.changeUser(id, newUsuario);
    }
}