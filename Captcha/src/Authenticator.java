import java.util.Scanner;

abstract class Authenticator {
    private String login;
    private String password;

    private String IIN;
    protected Scanner sc = new Scanner(System.in);

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIIN() {
        return IIN;
    }

    public void setIIN(String IIN) {
        this.password = IIN;
    }
}
