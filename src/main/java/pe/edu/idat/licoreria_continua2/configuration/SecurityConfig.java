package pe.edu.idat.licoreria_continua2.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pe.edu.idat.licoreria_continua2.service.DetalleUsuarioService;

@EnableWebSecurity
@AllArgsConstructor
@Configuration
public class SecurityConfig {

    private DetalleUsuarioService detalleUsuarioService;

    @Bean
    public SecurityFilterChain obtenerSecurity(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(
                auth -> auth.requestMatchers("/auth/login","/resources/**","/static/**",
                        "/css/**", "/js/**").permitAll().anyRequest().authenticated()).formLogin(
                login-> login.loginPage("/auth/login").defaultSuccessUrl("/auth/login-success")
                        .usernameParameter("nickusuario").passwordParameter("password")).logout(
                logout-> logout.logoutSuccessUrl("/auth/login")
                        .invalidateHttpSession(true)).authenticationProvider(obtenerAuthProvider());
        return httpSecurity.build();
    }



    @Bean
    public AuthenticationProvider obtenerAuthProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(detalleUsuarioService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }



}
