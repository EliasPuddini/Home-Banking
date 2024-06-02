package com.BancoSaintPatrick.HomeBanking.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    Long id;
    double dni;
    String nombre;
    double saldo;
    @OneToMany(mappedBy = "transacciones.emisor")
    List<Transaccion> recibido;
    @OneToMany(mappedBy = "transacciones.emisor")
    List<Transaccion> emitido;
    @OneToMany
    List<Tarjeta> tarjetas;
}