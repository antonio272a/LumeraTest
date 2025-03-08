package com.lumeratest.service;

import com.lumeratest.model.Protocolo;
import com.lumeratest.repository.ProtocoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProtocoloService {

  @Autowired
  private ProtocoloRepository repository;

  public Protocolo cadastrarProtocolo(Protocolo protocolo) {
    return repository.save(protocolo);
  }

  public List<Protocolo> listarProtocolos() {
    return repository.findAll();
  }
}
