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

    public Optional<Usuario> getUserById(long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            return usuario;
        }
        else {
            return null;
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
            Optional<Usuario> usuario = oldUsuario;
            usuario.get().setNomeCompleto(newUsuario.getNomeCompleto());
            usuario.get().setEmail(newUsuario.getEmail());
            usuario.get().setCpf(newUsuario.getCpf());
            usuarioRepository.save(usuario.get());
            return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}