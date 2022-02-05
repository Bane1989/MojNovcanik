import java.util.ArrayList;
import java.util.Scanner;

public class Racun {
    protected static int NextID = 1;
    private Korisnik vlasnikRacuna;
    private int brojRacuna;
    private double stanjeNaRacunu;
    private String tipRacuna;
    private String valuta;
    private ArrayList<Transakcije> nizSvihTransakcija;

    public Racun(Korisnik vlasnikRacuna) {
        this.vlasnikRacuna = vlasnikRacuna;
        this.stanjeNaRacunu = 0;
        this.tipRacuna = null;
        this.brojRacuna = NextID;
        NextID++;
        this.valuta = null;
        this.nizSvihTransakcija = new ArrayList<>();
    }

    public Racun(Korisnik vlasnikRacuna, String tipRacuna) {
        this.vlasnikRacuna = vlasnikRacuna;
        this.stanjeNaRacunu = 0;
        this.tipRacuna = tipRacuna;
        this.brojRacuna = NextID;
        NextID++;
        this.valuta = null;
        this.nizSvihTransakcija = new ArrayList<>();
    }

    public Korisnik getVlasnikRacuna() {
        return vlasnikRacuna;
    }

    public void setVlasnikRacuna(Korisnik vlasnikRacuna) {
        this.vlasnikRacuna = vlasnikRacuna;
    }

    public int getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(int brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public double getStanjeNaRacunu() {
        return stanjeNaRacunu;
    }

    public void setStanjeNaRacunu(double stanjeNaRacunu) {
        this.stanjeNaRacunu = stanjeNaRacunu;
    }

    public String getTipRacuna() {
        return tipRacuna;
    }

    public void setTipRacuna(String tipRacuna) {
        this.tipRacuna = tipRacuna;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public ArrayList<Transakcije> getNizSvihTransakcija() {
        return nizSvihTransakcija;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vlasnik racuna: ");
        sb.append(vlasnikRacuna);
        sb.append("\n");
        sb.append("Broj racuna: ");
        sb.append(brojRacuna);
        sb.append("\n");
        sb.append("Stanje na racunu: ");
        sb.append(stanjeNaRacunu);
        sb.append("\n");
        sb.append("Tip racuna: ");
        sb.append(tipRacuna);
        sb.append("\n");
        sb.append("Valuta racuna: ");
        sb.append(valuta);

        return sb.toString();
    }

    public void dodajTransakciju(Transakcije transakcija) {
        nizSvihTransakcija.add(transakcija);
    }

    public void prodjiKrozTransakcije(String kategorija) {
        for (Transakcije t : nizSvihTransakcija) {
            if (t.getKategorija().equalsIgnoreCase(kategorija)) {
                System.out.println("***************************************************");
                System.out.println(t);
                System.out.println("***************************************************");
            }
        }
    }


}
