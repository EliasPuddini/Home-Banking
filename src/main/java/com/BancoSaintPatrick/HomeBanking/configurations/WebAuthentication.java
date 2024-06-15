package com.BancoSaintPatrick.HomeBanking.configurations;

import com.BancoSaintPatrick.HomeBanking.dto.TarjetaDTO;
import com.BancoSaintPatrick.HomeBanking.models.Tarjeta;
import com.BancoSaintPatrick.HomeBanking.models.Usuario;
import com.BancoSaintPatrick.HomeBanking.repositories.TarjetaRepository;
import com.BancoSaintPatrick.HomeBanking.repositories.UsuarioRepository;
import com.BancoSaintPatrick.HomeBanking.services.TarjetaService;
import com.BancoSaintPatrick.HomeBanking.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    private UsuarioService usuarioService;

    @Bean
    public PasswordEncoder paswordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception{

        auth.userDetailsService(inputNumber ->{

            Usuario usuario = this.usuarioService.getUsuarioByCardNumber(Double.parseDouble(inputNumber));

            if(usuario != null){

                return new User(String.valueOf(usuario.getDni()),String.valueOf(usuario.getPassword()),AuthorityUtils.createAuthorityList("CLIENT"));

            }else{
                throw new UsernameNotFoundException("Unknow card: " + inputNumber);
            }
        });
    }

}
