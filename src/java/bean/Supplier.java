/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author TG
 */
public class Supplier {
    private String idSupplier;
    private String nameSupplier; // Supplier : Nha cung cap
    private String nameAbbreviations;// ten viet tat
    private String address;
    private String numberPhone;
    private String email;
    private String note;
    public Supplier(){
        
    }
    public Supplier(String idSupplier, String nameSupplier, String nameAbbreviations, String address, String numberPhone, String email, String note) {
        this.idSupplier = idSupplier;
        this.nameSupplier = nameSupplier;
        this.nameAbbreviations = nameAbbreviations;
        this.address = address;
        this.numberPhone = numberPhone;
        this.email = email;
        this.note = note;
    }

    public String getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(String idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getNameAbbreviations() {
        return nameAbbreviations;
    }

    public void setNameAbbreviations(String nameAbbreviations) {
        this.nameAbbreviations = nameAbbreviations;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Supplier{" + "idSupplier=" + idSupplier + ", nameSupplier=" + nameSupplier + ", nameAbbreviations=" + nameAbbreviations + ", address=" + address + ", numberPhone=" + numberPhone + ", email=" + email + ", note=" + note + '}';
    }
    
    
}
