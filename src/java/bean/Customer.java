package bean;

/**
 *
 * @author TG
 */
public class Customer {

    private String idcus;
    private String nameCus;
    private String dateofbirth;
    private String gender;
    private String numberphone;
    private String address;
    private String email;

    public Customer(String idcus, String nameCus, String dateofbirth, String gender, String numberphone, String address, String email) {
        this.idcus = idcus;
        this.nameCus = nameCus;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.numberphone = numberphone;
        this.address = address;
        this.email = email;
    }

    public Customer(String nameCus, String numberphone, String address, String email) {
        this.nameCus = nameCus;
        this.numberphone = numberphone;
        this.address = address;
        this.email = email;
    }

    public Customer(String nameCus, String dateofbirth, String gender, String numberphone, String address, String email) {
        this.nameCus = nameCus;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.numberphone = numberphone;
        this.address = address;
        this.email = email;
    }

    public Customer() {
    }

    public String getIdcus() {
        return idcus;
    }

    public void setIdcus(String idcus) {
        this.idcus = idcus;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
