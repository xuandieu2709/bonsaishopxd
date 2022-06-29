package bean;

public class Product {

    private String idProducts;
    private String nameProducts;
    private String image;
    private String desciption;
    private String unit;
    private int inventory; // tồn
    private long exPrice; // giá xuất
    private long imPrice; // giá nhập 
    private String note; // ghi chú
    private String idIndustry; // Mã nghành hàng
    private int amount; // Số lượng

    public Product() {

    }

    public Product(Product pr) {
        this.idProducts = pr.idProducts;
        this.nameProducts = pr.nameProducts;
        this.image = pr.image;
        this.desciption = pr.desciption;
        this.unit = pr.unit;
        this.inventory = pr.inventory;
        this.imPrice = pr.imPrice;
        this.exPrice = pr.exPrice;
        this.note = pr.note;
        this.idIndustry = pr.idIndustry;
    }

    public Product(String idProducts, String nameProducts, String image, long exPrice, int amount) {
        this.idProducts = idProducts;
        this.nameProducts = nameProducts;
        this.image = image;
        this.exPrice = exPrice;
        this.amount = amount;
    }
    

    public Product(String id,String nameP,String image,String des,String unit,int iven,long imPrice,long exPrice,String note, String idIndus) {
        this.idProducts = id;
        this.nameProducts = nameP;
        this.image = image;
        this.desciption = des;
        this.unit = unit;
        this.inventory = iven;
        this.imPrice = imPrice;
        this.exPrice = exPrice;
        this.note = note;
        this.idIndustry = idIndus;
    }

    public Product(String idProducts, String nameProducts, String image, String desciption, String unit, int inventory, long imPrice, long exPrice, String note, String idIndustry, int amount) {
        this.idProducts = idProducts;
        this.nameProducts = nameProducts;
        this.image = image;
        this.desciption = desciption;
        this.unit = unit;
        this.inventory = inventory;
        this.imPrice = imPrice;
        this.exPrice = exPrice;
        this.note = note;
        this.idIndustry = idIndustry;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    

    public String getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(String idProducts) {
        this.idProducts = idProducts;
    }

    public String getNameProducts() {
        return nameProducts;
    }

    public void setNameProducts(String nameProducts) {
        this.nameProducts = nameProducts;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public long getExPrice() {
        return exPrice;
    }

    public void setExPrice(long exPrice) {
        this.exPrice = exPrice;
    }

    public long getImPrice() {
        return imPrice;
    }

    public void setImPrice(long imPrice) {
        this.imPrice = imPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getIdIndustry() {
        return idIndustry;
    }

    public void setIdIndustry(String idIndustry) {
        this.idIndustry = idIndustry;
    }

    @Override
    public String toString() {
        return "Product{" + "idProducts=" + idProducts + ", nameProducts=" + nameProducts + ", image=" + image + ", desciption=" + desciption + ", unit=" + unit + ", inventory=" + inventory + ", exPrice=" + exPrice + ", imPrice=" + imPrice + ", note=" + note + ", idIndustry=" + idIndustry + '}';
    }
    
}
