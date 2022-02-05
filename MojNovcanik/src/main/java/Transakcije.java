public class Transakcije {
    private Racun racunPlatioca;
    private Racun racunPrimaoca;
    private double iznos;
    private String kategorija;

    public Transakcije(Racun racunPlatioca, Racun racunPrimaoca, double iznos, String kategorija) {
        this.racunPlatioca = racunPlatioca;
        this.racunPrimaoca = racunPrimaoca;
        this.iznos = 0;
        this.kategorija = kategorija;
    }
    public Transakcije(Racun racunPlatioca, double iznos, String kategorija) {
        this.racunPlatioca = racunPlatioca;
        this.iznos = 0;
        this.kategorija = kategorija;
    }

    public Racun getRacunPlatioca() {
        return racunPlatioca;
    }

    public void setRacunPlatioca(Racun racunPlatioca) {
        this.racunPlatioca = racunPlatioca;
    }

    public Racun getRacunPrimaoca() {
        return racunPrimaoca;
    }

    public void setRacunPrimaoca(Racun racunPrimaoca) {
        this.racunPrimaoca = racunPrimaoca;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sa racuna broj: ");
        sb.append(racunPlatioca.getBrojRacuna());
        sb.append(" na racun broj: ");
        sb.append(racunPrimaoca.getBrojRacuna());
        sb.append(" je uplaceno ");
        sb.append(iznos);
        sb.append(" ");
        sb.append(racunPlatioca.getValuta());

        return sb.toString();
    }


}
