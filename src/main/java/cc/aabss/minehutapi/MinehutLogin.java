package cc.aabss.minehutapi;

import org.jetbrains.annotations.Nullable;

/**
 * Minehut Login Class
 */
public class MinehutLogin {

    /**
     * Empty constructor
     */
    public MinehutLogin() {
    }

    /**
     * MinehutLogin constructor
     * @param t The minehut account token.
     * @param uid The minehut user id.
     * @param pid The minehut profile id.
     * @param sid The minehut session id.
     */
    private MinehutLogin(@Nullable String t, @Nullable String uid, @Nullable String pid, @Nullable String sid) {
        token = t;
        userid = uid;
        proid = pid;
        sesid = sid;
    }

    private static String token = null;
    private static String proid = null;
    private static String sesid = null;
    private static String userid = null;

    /**
     * A login builder (Tutorial: <a href="link">TODO: Add tutorial</a>)
     * @return A new builder.
     */
    public static MinehutLogin builder(){
        return new MinehutLogin();
    }

    /**
     * Sets the token of the builder.
     * @param token The minehut account token.
     * @return A new builder with the token.
     */
    public MinehutLogin token(String token){
        return new MinehutLogin(token, userid, proid, sesid);
    }

    /**
     * Sets the user id of the builder.
     * @param userid The minehut account user id.
     * @return A new builder with the user id.
     */
    public MinehutLogin userId(String userid){
        return new MinehutLogin(token, userid, proid, sesid);
    }

    /**
     * Sets the profile id of the builder.
     * @param proid The minehut account profile id.
     * @return A new builder with the profile id.
     */
    public MinehutLogin profileId(String proid){
        return new MinehutLogin(token, userid, proid, sesid);
    }

    /**
     * Sets the session id of the builder.
     * @param sesid The minehut account session id.
     * @return A new builder with the session id.
     */
    public MinehutLogin sessionId(String sesid){
        return new MinehutLogin(token, userid, proid, sesid);
    }

    /**
     * Builds the builder (will not work if credentials are invalid).
     * @return The logged in api with the credentials.
     */
    public MinehutAPI build(){
        return new MinehutAPI(token, userid, proid, sesid);
    }

}
