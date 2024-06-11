package com.BancoSaintPatrick.HomeBanking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    Long id;
    double dni;
    String nombre;
    double saldo;
    @OneToMany(mappedBy = "receptor")
    List<Transaccion> recibido;
    @OneToMany(mappedBy = "emisor")
    List<Transaccion> emitido;
    @OneToMany
    List<Tarjeta> tarjetas;
}