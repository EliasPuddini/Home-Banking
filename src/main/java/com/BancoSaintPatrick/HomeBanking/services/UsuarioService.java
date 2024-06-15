package com.BancoSaintPatrick.HomeBanking.services;

import com.BancoSaintPatrick.HomeBanking.dto.UsuarioDTO;
import com.BancoSaintPatrick.HomeBanking.models.Usuario;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> getall();
    UsuarioDTO getUsuarioByID(Long id);
    Usuario getUsuarioByCardNumber(double number);
    void deleteUsuario(Long id);
    void saveUsuario(Usuario usuario);
}
