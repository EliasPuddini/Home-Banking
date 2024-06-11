package com.BancoSaintPatrick.HomeBanking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    Long id;
    @ManyToOne
    @JoinColumn(name = "emisor_id")
    Usuario emisor;
    @ManyToOne
    @JoinColumn(name = "receptor_id")
    Usuario receptor;
    double monto;

}
