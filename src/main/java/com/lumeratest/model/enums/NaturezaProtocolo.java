package com.lumeratest.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum NaturezaProtocolo {
    FINANCEIRO(1),
    JURIDICO(2),
    ADMINISTRATIVO(3);

    private final int value;

    NaturezaProtocolo(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static NaturezaProtocolo fromValue(int value) {
        for (NaturezaProtocolo natureza : values()) {
            if (natureza.value == value) {
                return natureza;
            }
        }
        throw new IllegalArgumentException("Invalid NaturezaProtocolo value: " + value);
    }
}
