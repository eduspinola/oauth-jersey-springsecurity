package br.com.devmedia.wsjwt.config.security.basic;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
public class ConfiguracaoDeSeguranca {

    //@Configuration
    public static class ConfiguracaoParaAPI { //extends WebSecurityConfigurerAdapter {

        //@Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            //http
            //        .authorizeRequests()
            //           .antMatchers("/rest/login").permitAll()
            //           .anyRequest().authenticated().and()
            //        .antMatcher("/rest/**")
            //           .httpBasic()
            //              .and()
            //           .csrf().disable();
            // @formatter:on
        }

    }

}

