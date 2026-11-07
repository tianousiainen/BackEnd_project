package backend_project.finalproject;

import org.springframework.boot.security.autoconfigure.web.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
@EnableMethodSecurity (securedEnabled = true)
public class WebSecurityConfig {
    @Bean 
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/css/**").permitAll()
            .anyRequest().authenticated()
        )

        .csrf(csrf -> csrf 
            .ignoringRequestMatchers(PathRequest.toH2Console())
        )

        .headers(headers -> headers
            .frameOptions(frame -> frame.sameOrigin())
        )

        .formLogin(formLogin -> formLogin
            .defaultSuccessUrl("/studentlist", true)
            .permitAll()
        )

        .logout(logout -> logout
            .permitAll()
        );
        return http.build();
    }

    @Bean 
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
