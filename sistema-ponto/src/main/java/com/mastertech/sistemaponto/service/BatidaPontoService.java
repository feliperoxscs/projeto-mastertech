package com.mastertech.sistemaponto.service;

import java.util.Optional;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mastertech.sistemaponto.helper.CalculateHours;
import com.mastertech.sistemaponto.helper.ResponseHelper;
import com.mastertech.sistemaponto.model.BatidaPonto;
import com.mastertech.sistemaponto.model.Usuario;
import com.mastertech.sistemaponto.repository.BatidaPontoRepository;
import com.mastertech.sistemaponto.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BatidaPontoService { 

    @Autowired
    private BatidaPontoRepository batidaPontoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private ObjectMapper mapper = new ObjectMapper();

    public ResponseEntity<BatidaPonto> createBatidaPonto(BatidaPonto batidaPonto, long id){
        Optional<Usuario> userCompare = usuarioRepository.findById(id);
        if(userCompare.isPresent()){
            batidaPonto.setIdUsuario(id);
            batidaPontoRepository.save(batidaPonto);
            return new ResponseEntity<BatidaPonto>(batidaPonto, HttpStatus.CREATED);
        } 
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ResponseHelper> getBatidasUsuario(long id) throws Exception {
        Optional<Usuario> userCompare = usuarioRepository.findById(id);
        if(userCompare.isPresent()){
            Optional<List<BatidaPonto>> batidasPonto = batidaPontoRepository.findByIdUser(id);
            if(batidasPonto.isPresent()){
                ResponseHelper response = new ResponseHelper();
                response.setBatidasPonto(batidasPonto.get());
                response.setTotalHorasTrabalhadas(CalculateHours.calulateHours(batidasPonto.get()));
                return new ResponseEntity<ResponseHelper>(response, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}