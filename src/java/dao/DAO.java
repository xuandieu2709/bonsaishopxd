package dao;

import bean.Account;
import bean.Catagory;
import bean.Customer;
import bean.Order;
import bean.Product;
import bean.Supplier;
import com.mysql.cj.MysqlConnection;
import connect.Myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "Select * from sanpham";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getLong(7),
                        rs.getLong(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Product> getTopNiceProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "Select * from sanpham WHERE MaSP < 10";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getLong(7),
                        rs.getLong(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Catagory> getAllCatagory() {
        List<Catagory> list = new ArrayList<>();
        String sql = "Select * from nghanhhang";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Catagory(rs.getString(1), rs.getString(2)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    // getProductsByID Lay san pham thong qua ma nghanh
    public List<Product> getAllProductsByIDCatagory(String id) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * From sanpham WHERE MaNghanh = ?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getLong(7),
                        rs.getLong(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Product> getAllProductsByIDSupplier(String id) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT sp.MaSP,TenSP,HinhAnh,MoTa,DonViTinh,SLTon,GiaNhap,GiaXuat,sp.GhiChu,sp.MaNghanh\n"
                + "FROM sanpham sp INNER JOIN chitiet_sp_ncc ct ON sp.MaSP = ct.MaSP\n"
                + "INNER JOIN nhacungcap ncc ON ncc.MaNCC = ct.MaNCC\n"
                + "WHERE ct.MaNCC = ?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getLong(7),
                        rs.getLong(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Product> getAllProductsByIDCatagorySupplier(String cid, String sid) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT sp.MaSP,TenSP,HinhAnh,MoTa,DonViTinh,SLTon,GiaNhap,GiaXuat,sp.GhiChu,sp.MaNghanh\n"
                + "FROM sanpham sp INNER JOIN chitietsanphamncc ct ON sp.MaSP = ct.MaSP\n"
                + "INNER JOIN nhacungcap ncc ON ncc.MaNCC = ct.MaNCC\n"
                + "WHERE ct.MaNCC = ? and MaNghanh =?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, sid);
            ps.setString(2, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getLong(7),
                        rs.getLong(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public Product getProductsByIDProduct(String id) {
        String sql = "SELECT * From sanpham WHERE MaSP = ?";
        NumberFormat fm = NumberFormat.getNumberInstance();
        fm.setMinimumIntegerDigits(0);
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getLong(7),
                        rs.getLong(8),
                        rs.getString(9),
                        rs.getString(10),
                        1);
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean checkProductExist(String id) {
        String sql = "SELECT * FROM `sanpham` WHERE MaSP =?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean checkIdProductInDetailOrder(String idProduct) {
        String sql = " SELECT * FROM `chithietdonhang` WHERE MaSP = ?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, idProduct);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public Account login(String user, String pass) {
        String sql = "SELECT * From taikhoan WHERE TaiKhoan =? and MatKhau =? ";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Account loginCustomer(String user, String pass) {
        String sql = "SELECT DISTINCT tk.TaiKhoan,tk.MatKhau,cn.MaChucNang "
                + "From taikhoan tk INNER JOIN phanquyenkhachhang pq INNER JOIN chucnang cn "
                + "on tk.TaiKhoan = pq.TaiKhoan AND pq.MaChucNang = cn.MaChucNang WHERE tk.TaiKhoan = ?  and tk.MatKhau = ?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Account loginStaff(String user, String pass) {
        String sql = "SELECT DISTINCT tk.TaiKhoan,tk.MatKhau,cn.MaChucNang "
                + "From taikhoan tk INNER JOIN phanquyennhanvien pq INNER JOIN chucnang cn "
                + "on tk.TaiKhoan = pq.TaiKhoan AND pq.MaChucNang = cn.MaChucNang WHERE tk.TaiKhoan =? AND tk.MatKhau =?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Account checkAccountExist(String user) {
        String sql = "Select * from taikhoan where TaiKhoan =?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Account signup(String user, String pass) {
        String sql = "Insert into taikhoan values(?,?,3)";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void deleteProducts(String id) {
        String sql = "DELETE FROM `sanpham` WHERE MaSP = ?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void insertProducts(String name, String image, String des, String unit,
            int inven, long imP, long exP, String note, String idC) {
        String sql = "Insert into sanpham(`TenSP`, `HinhAnh`, `MoTa`, `DonViTinh`, `SLTon`, `GiaNhap`, `GiaXuat`, `GhiChu`, `MaNghanh`) values(?,?,?,?,?,?,?,?,?)";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, des);
            ps.setString(4, unit);
            ps.setInt(5, inven);
            ps.setLong(6, imP);
            ps.setLong(7, exP);
            ps.setString(8, note);
            ps.setString(9, idC);
            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateProducts(String name, String image, String des, String unit,
            int inven, long imP, long exP, String note, String idC, String id) {
        String sql = "UPDATE `sanpham` SET `TenSP`=?,`HinhAnh`=?,`MoTa`=?,`DonViTinh`=?,`SLTon`=?,`GiaNhap`=?,`GiaXuat`=?,`GhiChu`=?,`MaNghanh`=? WHERE MaSP = ?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, des);
            ps.setString(4, unit);
            ps.setInt(5, inven);
            ps.setLong(6, imP);
            ps.setLong(7, exP);
            ps.setString(8, note);
            ps.setString(9, idC);
            ps.setString(10, id);
            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Product> getTopSaleMost() {
        String sql = "SELECT * FROM `sanpham` ORDER BY SLTon LIMIT 12";
        List<Product> list = new ArrayList<>();
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getLong(7),
                        rs.getLong(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Supplier> getAllSupplier() {
        List<Supplier> list = new ArrayList<>();
        String sql = "Select * from nhacungcap";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Supplier(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public Catagory getCatalogByIdProduct(String idP) {
        String sql = "SELECT sp.MaNghanh,TenNghanh "
                + "From sanpham sp JOIN nghanhhang nh on sp.MaNghanh = nh.MaNghanh "
                + "where sp.MaSP = ?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, idP);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Catagory(rs.getString(1),
                        rs.getString(2));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Account> getAccountCustomer() {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT DISTINCT tk.TaiKhoan,tk.MatKhau,cn.MaChucNang"
                + " From taikhoan tk INNER JOIN phanquyenkhachhang pq INNER JOIN chucnang cn"
                + " on tk.TaiKhoan = pq.TaiKhoan AND pq.MaChucNang = cn.MaChucNang";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Account> getAccountStaff() {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT DISTINCT tk.TaiKhoan,tk.MatKhau,cn.MaChucNang "
                + "From taikhoan tk INNER JOIN phanquyennhanvien pq INNER JOIN chucnang cn "
                + "ON tk.TaiKhoan = pq.TaiKhoan AND pq.MaChucNang = cn.MaChucNang;";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Product> searchByNameProducts(String txtsearch) {
        List<Product> list = new ArrayList<>();
        String sql = "Select * from sanpham "
                + "WHERE TenSP LIKE '%" + txtsearch + "%' ";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getLong(7),
                        rs.getLong(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public int CountAllProducts() {
        String sql = "Select Count(*) from sanpham";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int CountByIDProduct(String id) {
        String sql = "SELECT COUNT(MaSP) FROM `sanpham` WHERE MaSP = ?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int CountAllProductsByIDCatalory(String id) {
        String sql = "Select Count(MaNghanh) from sanpham WHERE MaNghanh = ?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int CountAllProductsByIDSupplier(String id) {
        String sql = "SELECT COUNT(ncc.MaNCC)\n"
                + "FROM sanpham sp INNER JOIN chitietsanphamncc ct ON sp.MaSP = ct.MaSP\n"
                + "INNER JOIN nhacungcap ncc ON ncc.MaNCC = ct.MaNCC\n"
                + "WHERE ncc.MaNCC = ?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int CountAllProductsByNameProduct(String txt) {
        String sql = "SELECT COUNT(MaSP) FROM `sanpham` WHERE TenSP like '%" + txt + "%'";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public List<Product> pageProduct(int i) {
        List<Product> list = new ArrayList<>();
        //i = (i-1)*10;
        String sql = "SELECT * FROM `sanpham` ORDER  BY TenSP ASC LIMIT " + (i - 1) * 10 + ",10";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            // ps.setInt(1, (i-1)*10;
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getLong(7),
                        rs.getLong(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    // danh so trang khi click vao tung nghanh hang
    public List<Product> pageProductByIdCatagory(int i, String id) {
        List<Product> list = new ArrayList<>();
        //i = (i-1)*10;
        String sql = "SELECT * FROM `sanpham` WHERE MaNghanh = ? ORDER  BY TenSP ASC LIMIT " + (i - 1) * 10 + ",10";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            // ps.setInt(1, (i-1)*10;
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getLong(7),
                        rs.getLong(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Product> pageProductByIdSupplier(int i, String id) {
        List<Product> list = new ArrayList<>();
        //i = (i-1)*10;
        String sql = "SELECT DISTINCT sp.MaSP,TenSP,HinhAnh,MoTa,DonViTinh,SLTon,GiaNhap,GiaXuat,sp.GhiChu,sp.MaNghanh\n"
                + "FROM sanpham sp INNER JOIN chitietsanphamncc ct ON sp.MaSP = ct.MaSP\n"
                + "INNER JOIN nhacungcap ncc ON ncc.MaNCC = ct.MaNCC\n"
                + "WHERE ct.MaNCC = ?\n"
                + "ORDER  BY TenSP ASC LIMIT " + (i - 1) * 10 + ",10";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            // ps.setInt(1, (i-1)*10;
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getLong(7),
                        rs.getLong(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    // danh so trang ben tim kiem shop.jsp(shopControl)
    public List<Product> pageProductByNameProduct(int i, String txt) {
        List<Product> list = new ArrayList<>();
        //i = (i-1)*10;
        String sql = "SELECT * FROM `sanpham` WHERE TenSP LIKE '%" + txt + "%' ORDER BY MaSP LIMIT " + (i - 1) * 10 + ",10";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            // ps.setInt(1, (i-1)*10;
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getLong(7),
                        rs.getLong(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void insertCustomer(String name, String numberphone, String address, String email) {
        String sql = "INSERT INTO `khachhang`(`TenKH`,`SDT`, `DiaChi`, `Email`) VALUES (?,?,?,?)";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, numberphone);
            ps.setString(3, address);
            ps.setString(4, email);
            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String fomatMoney(long money) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str1 = currencyVN.format(money);
        return str1;
    }

    // kiem tra khach hang
    public boolean checkExistCustommer(String numberphone, String email) {
        String sql = "SELECT * FROM `khachhang` WHERE SDT = ? AND Email = ? ";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, numberphone);
            ps.setString(2, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Customer getCustommerByInforCus(String numberphone, String email) {
        String sql = "SELECT * FROM `khachhang` WHERE SDT = ? AND Email = ?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, numberphone);
            ps.setString(2, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Dat hang
    public void insertDetailOrder(int idOrder, int idCus, int idPro, int Amount) {
        String sql = "INSERT INTO `chithietdonhang`(`MaDH`, `MaKH`, `MaSP`, `SoLuong`) VALUES (?,?,?,?)";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idOrder);
            ps.setInt(2, idCus);
            ps.setInt(3, idPro);
            ps.setInt(4, Amount);
            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void insertNewOrder(String nameCus, String address, String numberphone, String email, int amount, long vat, long sum) {
        String sql = "INSERT INTO `donhang`(`TenKhachHang`, `DiaChi`, `SDT`, `Email`, `SoLuong`, `VAT`, `TongCong`) VALUES (?,?,?,?,?,?,?)";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nameCus);
            ps.setString(2, address);
            ps.setString(3, numberphone);
            ps.setString(4, email);
            ps.setInt(5, amount);
            ps.setLong(6, vat);
            ps.setLong(7, sum);
            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Order getLastIDOrder() {
        String sql = "SELECT MAX(MaDH) AS ID,NgayDat,SoLuong,VAT,TongCong,HTthanhtoan,TinhTrang FROM donhang";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Order(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getLong(4),
                        rs.getLong(5),
                        rs.getString(6),
                        rs.getString(7));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Order getNewOrderByNumberphoneOrEmail(String numderphone, String email, String address) {
        String sql = """
                     SELECT MAX(dh.MaDH) as 'MaDH',dh.NgayDat,dh.SoLuong,dh.VAT,dh.TongCong,dh.HTthanhtoan,dh.TinhTrang 
                     FROM donhang dh INNER JOIN chithietdonhang ct on dh.MaDH = ct.MaDH
                     INNER JOIN khachhang kh on kh.MaKH = ct.MaKH
                     Where kh.SDT = ? or kh.Email = ? and kh.DiaChi =? """;
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, numderphone);
            ps.setString(2, email);
            ps.setString(3, address);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Order(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getLong(4),
                        rs.getLong(5),
                        rs.getString(6),
                        rs.getString(7));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Order getNewOrderByLastIDOrder(String numderphone, String email) {
        String sql = "SELECT MAX(dh.MaDH) as 'MaDH',dh.NgayDat,dh.SoLuong,dh.VAT,dh.TongCong,dh.HTthanhtoan,dh.TinhTrang "
                + "FROM donhang dh INNER JOIN chithietdonhang ct on dh.MaDH = ct.MaDH INNER JOIN khachhang kh on kh.MaKH = ct.MaKH";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, numderphone);
            ps.setString(2, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Order(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getLong(4),
                        rs.getLong(5),
                        rs.getString(6),
                        rs.getString(7));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Order getAllOrderByIDOrder(String idOr) {
        String sql = "SELECT * FROM `donhang` WHERE MaDH = ?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, idOr);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Order(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getLong(8),
                        rs.getLong(9),
                        rs.getString(10),
                        rs.getString(11));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getAllProductByIDOrder(String idorder) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT sp.MaSP,sp.TenSP,sp.HinhAnh,sp.GiaXuat, ct.SoLuong From donhang dh INNER JOIN chithietdonhang ct on dh.MaDH = ct.MaDH INNER JOIN sanpham sp ON sp.MaSP = ct.MaSP WHERE dh.MaDH = ?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, idorder);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getLong(4),
                        rs.getInt(5)));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Order> getAllOrderByIDCustommer(String idCus) {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT DISTINCT dh.MaDH,dh.TenKhachHang,dh.DiaChi,dh.SDT,dh.Email,dh.NgayDat,dh.SoLuong,dh.VAT,dh.TongCong,dh.HTthanhtoan,dh.TinhTrang\n"
                + "FROM donhang dh INNER JOIN chithietdonhang ct ON dh.MaDH=ct.MaDH INNER JOIN khachhang kh ON kh.MaKH = ct.MaKH\n"
                + "WHERE kh.MaKH = ?";
        try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, idCus);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getLong(8),
                        rs.getLong(9),
                        rs.getString(10),
                        rs.getString(11)));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Order> getAllOrder(){
        List<Order> list = new ArrayList<>();
        String sql = "SELECT `MaDH`, `TenKhachHang`, `DiaChi`, `SDT`, `Email`, `NgayDat`, `SoLuong`, `VAT`, `TongCong`, `HTthanhtoan`, `TinhTrang` FROM `donhang` ";
    try {
            conn = Myconnection.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getLong(8),
                        rs.getLong(9),
                        rs.getString(10),
                        rs.getString(11)));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
