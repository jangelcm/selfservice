package pe.com.targethr.authserver.config.jwt;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import pe.com.targethr.authserver.dao.EmpleadoRepository;
import pe.com.targethr.authserver.dao.UsuarioRepository;
import pe.com.targethr.authserver.model.entity.EmpleadoEntity;
import pe.com.targethr.authserver.model.entity.UsuarioEntity;
import pe.com.targethr.authserver.model.jwt.CustomClaims;

public class CustomTokenEnhancer implements TokenEnhancer {

    private static final Logger log = LoggerFactory.getLogger(CustomTokenEnhancer.class);

    private UsuarioRepository usuarioRepository;

    private EmpleadoRepository empleadoRepository;

    public CustomTokenEnhancer(UsuarioRepository usuarioRepository, EmpleadoRepository empleadoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();
        CustomClaims customClaims = new CustomClaims();

        log.info("buscando informacion de usuario");
        UsuarioEntity usr = usuarioRepository.findByUsernameAndActivated(authentication.getName(), 1).get();
        customClaims.setCodigoUsuario(usr.getUserId().toString());

       log.info("buscando empleado del usuario {}", usr.getUserId());
        EmpleadoEntity emp = empleadoRepository.findByCodigoUsuarioAndEstado(usr.getUserId(), "1").get();
        log.info("empleado encontrado [cod_cia: {}, cod_suc: {}, cod_tra: {}]", emp.getId().getIdSucursal(),
                emp.getId().getCodigoTrabajador());
        customClaims.setCodigoCompania("034");
        customClaims.setCodigoSucursal(""+emp.getId().getIdSucursal());
        customClaims.setCodigoTrabajador(emp.getId().getCodigoTrabajador());
        customClaims.setNombre(emp.getNombre());
        customClaims.setApellidoPaterno(emp.getApellidoPaterno());
        customClaims.setApellidoMaterno(emp.getApellidoMaterno());
        customClaims.setEmail(emp.getEmail());
        customClaims.setCodigoTrabajadorJefe(emp.getJefeCodigo());
        customClaims.setNivel("2");

        log.info("buscando subordinados del empleado {}", emp.getId().getCodigoTrabajador());
        long subordinados = empleadoRepository.countByCodigoTrabajadorJefe(""+emp.getId().getIdSucursal(),
                emp.getId().getCodigoTrabajador());
        log.debug("nro de subordinados: {}", subordinados);
        customClaims.setJefe(subordinados > 0);

        additionalInfo.put("custom_info", customClaims);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}