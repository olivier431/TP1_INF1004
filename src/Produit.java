import java.util.Date;

public class Produit {
    private String nom;
    private int quantite;

    private int prix;

    private Date dateExpiration;

    public Produit(String nom, int quantite, int prix, Date dateExpiration) {
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
        this.dateExpiration = dateExpiration;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
