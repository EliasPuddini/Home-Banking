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
    private Long id;
    private double dni;
    private String nombre;
    private double saldo;
    @OneToMany(mappedBy = "receptor")
    private List<Transaccion> recibido;
    @OneToMany(mappedBy = "emisor")
    private List<Transaccion> emitido;
    @OneToMany
    private List<Tarjeta> tarjetas;
    private String password;
}