package bean;
public class Account {

    private String username;
    private String password;
    private String idfunction;

    public Account() {

    }

    public Account(Account ac) {
        this.username = ac.username;
        this.password = ac.password;
        this.idfunction = ac.idfunction;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public Account(String us, String ps, String id){
        this.username = us;
        this.password = ps;
        this.idfunction = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdfunction() {
        return idfunction;
    }

    public void setIdfunction(String idfunction) {
        this.idfunction = idfunction;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", idfunction=" + idfunction + '}';
    }

}
