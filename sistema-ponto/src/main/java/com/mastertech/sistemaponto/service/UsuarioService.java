package com.mastertech.sistemaponto.service;

import java.util.List;
import java.util.Optional;
import com.mastertech.sistemaponto.model.Usuario;
import com.mastertech.sistemaponto.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsers() {
        return usuarioRepository.findAll();
    }

    public ResponseEntity<Usuario> getUserById(long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public Usuario createUser(Usuario usuario) {
        Optional<Usuario> userCompare = usuarioRepository.findByCpf(usuario.getCpf());
        if(userCompare.isPresent()){
            return userCompare.get();
        }
        else {
            return usuarioRepository.save(usuario);
        }
    }

    public ResponseEntity<Usuario> changeUser(long id, Usuario newUsuario) {
        Optional<Usuario> oldUsuario = usuarioRepository.findById(id);
        if(oldUsuario.isPresent()) {
            Usuario usuario = oldUsuario.get();
            usuario.setNomeCompleto(newUsuario.getNomeCompleto());
            usuario.setEmail(newUsuario.getEmail());
            usuario.setCpf(newUsuario.getCpf());
            usuarioRepository.save(usuario);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}