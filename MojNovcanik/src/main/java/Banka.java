import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.Scanner;

public class Banka {
    static Scanner sc = new Scanner(System.in);

    private String ime;
    private ArrayList<Korisnik> nizSvihKorisnika;
    private Korisnik ulogovanKorisnik;
    private ArrayList<Transakcije> nizSvihTransakcija;


    public Banka(String ime) {
        this.ime = ime;
        this.nizSvihKorisnika = new ArrayList<>();
        this.nizSvihTransakcija = new ArrayList<>();
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public ArrayList<Korisnik> getNizSvihKorisnika() {
        return nizSvihKorisnika;
    }

    public void setNizSvihKorisnika(ArrayList<Korisnik> nizSvihKorisnika) {
        this.nizSvihKorisnika = nizSvihKorisnika;
    }

    public ArrayList<Transakcije> getNizSvihTransakcija() {
        return nizSvihTransakcija;
    }


    public Korisnik getUlogovanKorisnik() {
        return ulogovanKorisnik;
    }

    public void setUlogovanKorisnik(Korisnik ulogovanKorisnik) {
        this.ulogovanKorisnik = ulogovanKorisnik;
    }

    public void glavniMeni() {
        System.out.println("Odaberite neku od opcija tako sto cete uneti redni broj te opcije:\n" +
                "1. SingUp\n2. Login\n9. Izlaz iz programa");
        int odabir = sc.nextInt();
        if (odabir == 1) {
            singUp();
            System.out.println("***************************************************");
            System.out.println("Kreireli ste nalog.");
            System.out.println("***************************************************");
            podGlavniMeni();
        } else if (odabir == 2) {
            podGlavniMeni();
        } else if (odabir == 9) {
            System.out.println("Izasli ste iz programa.");
            System.exit(0);
        }
    }

    public void singUp() {
        System.out.println("Unesite vase ime: ");
        String firstName = sc.next();
        System.out.println("Unesite vase prezime: ");
        String lastName = sc.next();
        System.out.println("Unesite username: ");
        String username = sc.next();
        System.out.println("Unesite password: ");
        String password = sc.next();
        Korisnik noviKorisnik = new Korisnik(firstName, lastName, username, password);
        nizSvihKorisnika.add(noviKorisnik);
        Excel.sheet = Excel.wb.createSheet(firstName + " " + lastName);
        Row red1 = Excel.sheet.createRow(0);
        Cell kolona1 = red1.createCell(0);
        kolona1.setCellValue("Ime");
        Cell kolona2 = red1.createCell(0);
        kolona2.setCellValue("Prezime");
        Cell kolona3 = red1.createCell(0);
        kolona3.setCellValue("Username");
        Cell kolona4 = red1.createCell(0);
        kolona4.setCellValue("Password");
    }

    public void podGlavniMeni() {
        int count = 1;
        while(count > 0) {
            try {
                login();
                count = -1;
            }
            catch (Exception e) {
                System.out.println("***************************************************");
                System.out.println(e.getMessage());
                System.out.println("***************************************************");
                count--;
            }
        }
        if (count == 0) {
            glavniMeni();
        }
    }

    public void login() throws Exception {
        System.out.println("Ulogujte se na svoj nalog.\n");
        System.out.println("Unesite vas username: ");
        String username = sc.next();
        System.out.println("Unesite vas password: ");
        String password = sc.next();
        Korisnik ulogovanKorisnik = null;
        if (nizSvihKorisnika.isEmpty()) {
            throw new Exception("Nepostojeci korisnik!");
        }

        boolean t = false;
        for (Korisnik k : nizSvihKorisnika) {
            if (username.equals(k.getUsername()) && password.equals(k.getPassword())) {
                System.out.println("***************************************************");
                System.out.println("Dobrodosli " + k.getIme() + " " + k.getPrezime() +  "!");
                System.out.println("***************************************************");
                ulogovanKorisnik = k;
                t = true;
            }
        }
        if (t == false) {
            throw new Exception("Pogresan username ili password.");
        }
        setUlogovanKorisnik(ulogovanKorisnik);
    }


    public void odabirOpcijaUBanci(Korisnik korisnik) throws Exception {
        boolean running = true;
        while (running) {
            try {
                System.out.println("Odaberite opciju:\n" +
                        "1. Kreiraj racun\n2. Ukloni racun\n3. Izaberi racun\n8. Izbrisite svoj nalog\n9. Izlaz iz Programa\n0. Logout");
                int odabir = sc.nextInt();
                if (odabir == 1) {
                    kreiranjeRacuna(korisnik);
                } else if (odabir == 2) {
                    uklanjanjeRacuna(korisnik);
                } else if (odabir == 3) {
                    izaberiRacun(korisnik);
                } else if (odabir == 8) {
                    System.out.println("Da li stvarno zelite da izbrisete nalog?\n1. Da\n2. Ne");
                    int brisanje = sc.nextInt();
                    if (brisanje == 1) {
                        running = false;
                        System.out.println("Izbrisali ste svoj nalog.");
                        nizSvihKorisnika.remove(korisnik);
                        throw new Exception();

                    } else if (brisanje == 2) {
                        System.out.println("***************************************************");
                        System.out.println("Hvala Vam na poverenju.");
                        System.out.println("***************************************************");
                    }
                } else if (odabir == 9) {
                    System.exit(0);
                } else if (odabir == 0) {
                    System.out.println("***************************************************");
                    System.out.println("Izlogovali ste se.");
                    System.out.println("***************************************************");
                    throw new Exception();
                }
            } catch (Exception e) {
                throw e;
            }
        }

    }

    public void kreiranjeRacuna(Korisnik korisnik){
        Racun racun = new Racun(korisnik);
        System.out.println("Unesite tip bankovnog racuna koji kreirate:\n1. Dinarski\n2. Devizni");
        int odabir = sc.nextInt();
        if (odabir == 1) {
            racun.setTipRacuna("Dinarski");
            racun.setValuta("rsd");
        } else if (odabir == 2) {
            racun.setTipRacuna("Devizni");
            System.out.println("Odaberite valutu deviznog racuna:\n1. Euro\n2. Dolar\n3. Franak");
            int odabir1 = sc.nextInt();
            if (odabir1 == 1) {
                racun.setValuta("eur");
            } else if (odabir1 == 2) {
                racun.setValuta("usd");
            } else if (odabir1 == 3) {
                racun.setValuta("chf");
            }
        }

            korisnik.kreirajRacun(racun);
            System.out.println("***************************************************");
            System.out.println( "Kreirali ste racun.\n" + racun );
            System.out.println("***************************************************");
        }





    public void uklanjanjeRacuna(Korisnik korisnik){
        korisnik.ispisSvihRacuna();
        System.out.println("Unesite broj racuna koji zelite da uklonite: ");
        int broj = sc.nextInt();
        Racun racun = null;
        if (korisnik.getNizBankovnihRacunaKorisnika().isEmpty()) {
            System.out.println("***************************************************");
            System.out.println("Korisnik nema bankovnih racuna.");
            System.out.println("***************************************************");

        } else {

            {

                for (Racun r : korisnik.getNizBankovnihRacunaKorisnika()) {
                    if (broj == r.getBrojRacuna()) {
                        racun = r;
                        System.out.println("***************************************************");
                        System.out.println("Racun je uklonjen.");
                        System.out.println("***************************************************");
                        korisnik.ukloniRacun(racun);
                    }
                }
            }
        }
    }

    public void izaberiRacun(Korisnik korisnik)  {
        korisnik.ispisSvihRacuna();
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite broj bankovnog racuna: ");
        int broj = sc.nextInt();
        Racun racun = null;
        if (korisnik.getNizBankovnihRacunaKorisnika().isEmpty()) {
            System.out.println("***************************************************");
            System.out.println("Korisnik nema bankovnih racuna");
            System.out.println("***************************************************");
        } else {

            for (Racun r : korisnik.getNizBankovnihRacunaKorisnika()) {
                if (broj == r.getBrojRacuna()){
                    racun = r;
                    System.out.println("***************************************************");
                    System.out.println(r);
                    System.out.println("***************************************************");
                    boolean running = true;
                    while (running) {
                        try {
                            System.out.println("Odaberite opciju koju zelite:\n1. Uplata na racun\n2. Isplata sa racuna" +
                                    "\n3. Stanje na racunu\n4. Promena valute\n5. Transakcije\n0. Nazad");
                            int odabir = sc.nextInt();
                            switch (odabir) {
                                case 1:
                                    korisnik.dodajNovacNaRacun(racun);
                                    break;
                                case 2:
                                    korisnik.skiniNovacSaRacuna(racun);
                                    break;
                                case 3:
                                    korisnik.stanjeNaRacunu(racun);
                                    break;
                                case 4:
//                        promenaValuteRacuna(racun);
                                    break;
                                case 5:
                                    transakcija(racun);
                                    break;
                                case 0:
                                    Exception greska = new Exception();
                                    throw greska;
                                default:
                            }
                        } catch (Exception e) {
                            running = false;
                        }
                    }
                }
            }
        }
    }

    public void transakcija(Racun racun) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite racun primaoca: ");
        int brojRacunaPrimaoca = sc.nextInt();
        Racun racunPrimaoca = null;
        for (Korisnik k : nizSvihKorisnika) {
            for (Racun r : k.getNizBankovnihRacunaKorisnika()) {
                if (!r.getValuta().equalsIgnoreCase(racun.getValuta())) {
                    System.out.println("***************************************************");
                    System.out.println("Nemoguce je placati u razlicitim valutama.");
                    System.out.println("***************************************************");
                    break;
                } else if (r.getBrojRacuna() == brojRacunaPrimaoca){
                    racunPrimaoca = r;
                } else {
                     System.out.println("***************************************************");
                     System.out.println("Broj racuna je nepostojeci.");
                     System.out.println("***************************************************");
                 }
                break;
            }
            break;
        }
        if (racunPrimaoca != null) {
            System.out.println("Unesite iznos koji uplacujete: ");
            double iznosRacuna = sc.nextDouble();
            if (racunPrimaoca.getStanjeNaRacunu() < iznosRacuna) {
                System.out.println("***************************************************");
                System.out.println("Nemate dovoljno sredstava na racunu.");
                System.out.println("***************************************************");
            } else {
                System.out.println("Unesite kategoriju transakcije: ");
                String kategorijaTranskcije = sc.next();
                Transakcije transakcija = new Transakcije(racun, racunPrimaoca, iznosRacuna, kategorijaTranskcije);
                racun.dodajTransakciju(transakcija);
            }
        }
    }



}
