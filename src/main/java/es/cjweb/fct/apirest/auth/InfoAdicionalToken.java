package es.cjweb.fct.apirest.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import es.cjweb.fct.apirest.models.entity.Usuario;
import es.cjweb.fct.apirest.models.services.IUserService;

@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	@Autowired
	private IUserService userService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = userService.findByEmail(authentication.getName());
		Map<String,Object> info = new HashMap();
		info.put("info adicional", "hola que tal ".concat(usuario.getNombre()));
		info.put("id", usuario.getId());
		info.put("nombre", usuario.getNombre());
		info.put("apellidos", usuario.getApellidos());
		info.put("email", usuario.getEmail());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}
	
	
}
