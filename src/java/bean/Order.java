
package bean;

/**
 *
 * @author TG
 */
public class Order {
    private int idOrder;
    private String dateOrder;
    private String nameCustommer;
    private String address;
    private String numberphone;
    private String email;
    private int amount;
    private long vat;
    private long sum;
    private String payments;
    private String status;
    
    public Order() {
    }

    public Order(int idOrder, String dateOrder, String nameCustommer, String numberphone, String email, int amount, long vat, long sum, String payments, String status) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.nameCustommer = nameCustommer;
        this.numberphone = numberphone;
        this.email = email;
        this.amount = amount;
        this.vat = vat;
        this.sum = sum;
        this.payments = payments;
        this.status = status;
    }
    

    public Order(int idOrder, String dateOrder, int amount, long vat, long sum) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.amount = amount;
        this.vat = vat;
        this.sum = sum;
    }

    public Order(int idOrder, String dateOrder, int amount, long vat, long sum, String payments, String status) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.amount = amount;
        this.vat = vat;
        this.sum = sum;
        this.payments = payments;
        this.status = status;
    }
    public Order(int idOrder ,String nameCustommer, String address, String numberphone, String email, String dateOrder, int amount, long vat, long sum, String payments, String status) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.nameCustommer = nameCustommer;
        this.address = address;
        this.numberphone = numberphone;
        this.email = email;
        this.amount = amount;
        this.vat = vat;
        this.sum = sum;
        this.payments = payments;
        this.status = status;
    }
    

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getVat() {
        return vat;
    }

    public void setVat(long vat) {
        this.vat = vat;
    }
    

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNameCustommer() {
        return nameCustommer;
    }

    public void setNameCustommer(String nameCustommer) {
        this.nameCustommer = nameCustommer;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
    
}
