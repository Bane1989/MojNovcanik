import java.util.ArrayList;
import java.util.Scanner;

public class Korisnik {
    private String ime;
    private String prezime;
    private String username;
    private String password;
    private ArrayList<Racun> nizBankovnihRacunaKorisnika;

    public Korisnik(String ime, String prezime, String username, String password) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.nizBankovnihRacunaKorisnika = new ArrayList<>();
    }

    public Korisnik(String username, String password) {
        this.username = username;
        this.password = password;
        this.nizBankovnihRacunaKorisnika = new ArrayList<>();
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
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

    public ArrayList<Racun> getNizBankovnihRacunaKorisnika() {
        return nizBankovnihRacunaKorisnika;
    }

    public void setNizBankovnihRacunaKorisnika(ArrayList<Racun> nizBankovnihRacunaKorisnika) {
        this.nizBankovnihRacunaKorisnika = nizBankovnihRacunaKorisnika;
    }

    public void kreirajRacun(Racun racun){
        nizBankovnihRacunaKorisnika.add(racun);
    }


    public void ukloniRacun(Racun racun) {
        nizBankovnihRacunaKorisnika.remove(racun);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ime);
        sb.append(" ");
        sb.append(prezime);

        return sb.toString();
    }


    public void dodajNovacNaRacun (Racun racun) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite koliko novca zelite da dodate na racun: ");
        double unos = sc.nextDouble();
        racun.setStanjeNaRacunu(racun.getStanjeNaRacunu() + unos);
        System.out.println("***************************************************");
        System.out.println("Na vas racun je dodato " + unos + " " + racun.getValuta());
        System.out.println("***************************************************");
    }

    public void skiniNovacSaRacuna(Racun racun) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite koliko novca zelite da skinete sa racuna: ");
        double unos = sc.nextDouble();
            if (racun.getStanjeNaRacunu() < unos) {
                System.out.println("***************************************************");
                System.out.println("Nemate dovoljno sredstava na racunu.");
                System.out.println("***************************************************");
            } else {
                racun.setStanjeNaRacunu(racun.getStanjeNaRacunu() - unos);
                System.out.println("***************************************************");
                System.out.println("Sa vaseg racuna je skinuto " + unos + " " + racun.getValuta());
                System.out.println("***************************************************");
            }
    }

    public void stanjeNaRacunu(Racun racun) {
        System.out.println("***************************************************");
        System.out.println("Stanje na vasem racunu je " + racun.getStanjeNaRacunu() + " " + racun.getValuta());
        System.out.println("***************************************************");
    }

    public void ispisSvihRacuna() {
        for (Racun r : nizBankovnihRacunaKorisnika) {
            System.out.println("***************************************************");
            System.out.println(r);
            System.out.println("***************************************************");
        }
    }
}
