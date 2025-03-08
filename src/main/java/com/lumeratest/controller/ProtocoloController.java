package com.lumeratest.controller;

import com.lumeratest.model.Protocolo;
import com.lumeratest.service.ProtocoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/protocolos")
@CrossOrigin(origins = "*") // Allow frontend to access API
public class ProtocoloController {

  @Autowired
  private ProtocoloService service;

  @PostMapping
  public Protocolo cadastrarProtocolo(@RequestBody Protocolo protocolo) {
    return service.cadastrarProtocolo(protocolo);
  }

  @GetMapping
  public List<Protocolo> listarProtocolos() {
    return service.listarProtocolos();
  }
}
