package com.lumeratest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lumeratest.model.Protocolo;

@Repository
public interface ProtocoloRepository extends JpaRepository<Protocolo, Long> {
}