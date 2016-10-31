package masterSpringMvc.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

public class AuthenticatingSignInAdapter implements SignInAdapter {
	
	public static void authenticate(Connection<?> connection) {
		UserProfile userProfile = connection.fetchUserProfile();
		String username = userProfile.getUsername();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, null);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		System.out.println(String.format("User %s %s connected.",
		userProfile.getFirstName(), userProfile.getLastName()));
	}

	@Override
	public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
		authenticate(connection);
		return null;
	}

}
