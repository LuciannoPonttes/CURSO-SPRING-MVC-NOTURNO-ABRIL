package apiacessobancodados.apiacessobancodados.security;

public class Autenticacao {

    private Long id;
    private String authorization;

    private String xcsrfToken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getXcsrfToken() {
        return xcsrfToken;
    }

    public void setXcsrfToken(String xcsrfToken) {
        this.xcsrfToken = xcsrfToken;
    }


}
