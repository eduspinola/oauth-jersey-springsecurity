package br.com.devmedia.wsjwt.config;

import br.com.devmedia.wsjwt.webservice.filter.JWTAuthenticationFilter;
import br.com.devmedia.wsjwt.webservice.filter.JWTAuthorizationFilter;
import br.com.devmedia.wsjwt.webservice.mapper.*;
import br.com.devmedia.wsjwt.webservice.resource.LoginJWTResource;
import br.com.devmedia.wsjwt.webservice.resource.MarcaResource;
import br.com.devmedia.wsjwt.webservice.resource.ProdutoResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("rest")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

    }

    @PostConstruct
    public void setUp() {
        packages("br.com.devmedia.wsjwt");
        /*register(LoginJWTResource.class);
        register(MarcaResource.class);
        register(ProdutoResource.class);
        register(UnauthenticatedExceptionMapper.class);
        register(UnauthorizedExceptionMapper.class);
        register(EntidadeNaoExisteExceptionMapper.class);
        register(IdInvalidoExceptionMapper.class);
        register(WebApplicationExceptionMapper.class);*/
    }
}
