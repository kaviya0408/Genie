package integration.plugin.authenticate;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static integration.plugin.authenticate.Encryption.encrypt;
public class AuthenticationProcess {
    String hashValue;
    public LoginResponse authenticate(String userId, String password){
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.tokenId();
        loginResponse.getKey();
        loginResponse.isValidUser();
        hashValue =encrypt(password);
        return loginResponse;
    }
    public static void main (String[]args){
        AuthenticationProcess authenticationProcess = new AuthenticationProcess();
        authenticationProcess.authenticate("kaviya","Kaviya@04");
        authenticationProcess.authenticate("Ram","Ram@02");
        System.out.println(authenticationProcess.hashValue);
    }

}
