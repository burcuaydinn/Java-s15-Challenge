package library.users;

public class NormalUser extends User {
    public NormalUser(String id, String isim, String telefonNumarası) {
        super(id, isim, telefonNumarası);

    }
    public void setIsim(String isim) {
        this.isim = isim;
    }


    public void setTelefonNumarası(String telefonNumarası) {
        this.telefonNumarası = telefonNumarası;
    }
}