package integration.plugin.authenticate;
import java.security.Key;
import java.time.Instant;
import java.util.UUID;
import java.util.function.Supplier;
public class LoginResponse {
    public int tokenId;
    public Key[][] key;
    public boolean isValidUser;
    //TokenId
    public void tokenId() {
        Supplier<String> tokenId = () -> {

            StringBuilder token = new StringBuilder();
            long currentTimeInMilisecond = Instant.now().toEpochMilli();
            return token.append(currentTimeInMilisecond).append("-")
                    .append(UUID.randomUUID().toString()).toString();
        };
        System.out.println(tokenId.get());
    }
    //isValidUser
    public boolean isValidUser() {
        return isValidUser;
    }
    public void setValidUser(boolean validUser) {
        isValidUser = validUser;
    }
    //key
    public Key[][] getKey() {
        return key;
    }
    public void setKey(Key[][] key) {

        this.key = key;
    }
}



/*public int getTokenId() {
 *//* Supplier<String> tokenSupplier = () -> {

            StringBuilder token = new StringBuilder();
            long currentTimeInMilisecond = Instant.now().toEpochMilli();
            return token.append(currentTimeInMilisecond).append("-")
                    .append(UUID.randomUUID().toString()).toString();
        };*//*
        return tokenId;
    }
    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }*/


