package jMBGVerifikator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LokacijaJMBG {
	
//	Drzava se odnosi na drzavu u kojoj je osoba rodjena. Pokrajina je kod Srbije (Centralna Srbija, Kosovo ili Vojvodina). Region
//	se odnosi na region u kom je rodjena osoba. Ucitava se iz fajla Regioni2.txt.
//	SifraDrzave je broj koji se dobija iz JMBG-a, a na osnovu ove sifre ce se Dodeliti naziv drzave i pokrajine (za Srbiju).
	
	private String drzava;
	private String pokrajina;
	private String region;
	private int sifraDrzave;
	
	public String getDrzava() {
		return drzava;
	}
	
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	
	public void setDrzava (){
		if (sifraDrzave>=10 && sifraDrzave <=19){
			setDrzava("Bosna i Herzegovina");
			setPokrajina("Nema");
		}
		if (sifraDrzave>=20 && sifraDrzave <=29){
			setDrzava("Crna Gora");
			setPokrajina("Nema");
		}
		if (sifraDrzave>=30 && sifraDrzave <=39){
			setDrzava("Hrvatska");
			setPokrajina("Nema");
		}
		if (sifraDrzave>=40 && sifraDrzave <=49){
			setDrzava("Makedonija");
			setPokrajina("Nema");
		}
		if (sifraDrzave>=50 && sifraDrzave <=59){
			setDrzava("Slovenija");
			setPokrajina("Nema");
		}
		if (sifraDrzave>=70 && sifraDrzave <=79){
			setDrzava("Srbija");
			setPokrajina("Centralna Srbija");
		}
		if (sifraDrzave >=80 && sifraDrzave <=89){
			setDrzava("Srbija");
			setPokrajina("Vojvodina");
		}
		if (sifraDrzave>=90 && sifraDrzave <=99){
			setDrzava("Srbija");
			setPokrajina("Kosovo i Metohija");
		}
	}


	public String getPokrajina() {
		return pokrajina;
	}

	public void setPokrajina(String pokrajina) {
		this.pokrajina = pokrajina;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion (int brojRegiona){
		try {
			String filename = "C:/Documents and Settings/Marko/workspace/Moj Broj/Regioni2.txt";
			BufferedReader br = new BufferedReader(new FileReader(filename));
			boolean kraj = false;
			while (!kraj){
				String a = br.readLine();
				if (Integer.parseInt(a.substring(0, 2)) == brojRegiona){
					region = a.substring((a.lastIndexOf('-')+2));
					br.close();
					break;
				}else{
					region = "Proverite da li je ispravno unet JMBG";
				}
			}	
		} catch (FileNotFoundException e) {
			region = "Nepoznato.";
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public int getSifraDrzave() {
//		return sifraDrzave;
//	}

	public void setSifraDrzave(int regija) {
		this.sifraDrzave = regija;
	}
	
}
