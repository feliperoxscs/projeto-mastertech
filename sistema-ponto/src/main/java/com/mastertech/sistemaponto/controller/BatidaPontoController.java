package com.mastertech.sistemaponto.controller;

import com.mastertech.sistemaponto.helper.ResponseHelper;
import com.mastertech.sistemaponto.model.BatidaPonto;
import com.mastertech.sistemaponto.service.BatidaPontoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatidaPontoController {
    
    @Autowired
    private BatidaPontoService batidaPontoService;

    @RequestMapping(value = "/baterPonto/{idUser}", method = RequestMethod.POST)
    public ResponseEntity<BatidaPonto> createBatidaPonto(@PathVariable(value = "idUser") long idUser, @RequestBody BatidaPonto batidaPonto){
        return batidaPontoService.createBatidaPonto(batidaPonto, idUser);
    }

    @RequestMapping(value = "/ponto/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<ResponseHelper> detalhesBatida(@PathVariable(value = "idUser") long idUser) throws Exception{
        return batidaPontoService.getBatidasUsuario(idUser);
    }
}