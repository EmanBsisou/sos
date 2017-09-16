package oauth;

public interface AccessTokenValidator {
    AccessTokenValidationResult validate(String accessToken);
}