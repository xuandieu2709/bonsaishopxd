/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

public class DetailOrder {

    private int idKey;
    private int idOrder;
    private int idCustommer;
    private int idProduct;
    private int amount;

    public DetailOrder() {
    }

    public DetailOrder(int idKey, int idOrder, int idCustommer, int idProduct, int amount) {
        this.idKey = idKey;
        this.idOrder = idOrder;
        this.idCustommer = idCustommer;
        this.idProduct = idProduct;
        this.amount = amount;
    }

    public int getIdKey() {
        return idKey;
    }

    public void setIdKey(int idKey) {
        this.idKey = idKey;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdCustommer() {
        return idCustommer;
    }

    public void setIdCustommer(int idCustommer) {
        this.idCustommer = idCustommer;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
