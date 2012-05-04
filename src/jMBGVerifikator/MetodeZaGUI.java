package jMBGVerifikator;

//	Smisao ove klase je da objedini sve metode koje ce koristiti klasa JMBGValidatorGUI na jednom mestu. Zbog toga su ponovljene get/set
//	metode iz klasa PolJMBG, LokacijaJMBG i DatumJMBG, samo pod drugim nazivima. Pri tom su set metode objedinjene.
//	Dakle, prvo se izvrsava unos i provera JMBG-a. On se konvertuje u niz brojeva (13 int-ova). Kasnije se na osnovu prvih 7 cifara
//	dodeljuje datum rodjenja. Zatim su ponovljene get metode jer nisam zeleo da objekat d klase DatumJMBG ucinim javnim. Slicno je i
//	za objekte lok i p.

public class MetodeZaGUI {
	
	int [] brojevi = new int[13];
	DatumJMBG d = new DatumJMBG();
	PolJMBG p = new PolJMBG();
	LokacijaJMBG lok = new LokacijaJMBG();
	
	public void unosJMBGa (String maticniBroj){
		try {
			if (maticniBroj.length() != 13){
				throw new NumberFormatException ();
			}
			for (int i = 0; i < 13; i++) {
				brojevi[i] = Character.digit(maticniBroj.charAt(i), 10);
			}
		} catch (NumberFormatException e){
			System.err.println("Greska. Morate uneti 13-cifren broj");
		}
	}
	
	public boolean proveraJMBGa (){
		int k = (7*(brojevi[0]+brojevi[6])+6*(brojevi[1]+brojevi[7])
				+5*(brojevi[2]+brojevi[8])+4*(brojevi[3]+brojevi[9])
				+3*(brojevi[4]+brojevi[10])+2*(brojevi[5]+brojevi[11]))%11;
		if ((11-k)!= brojevi[12]) {
			return false;
		}else{
			return true;
		} 
	}
	
//	public boolean unosJMBGa2 (String maticniBroj){
//		try {
//			if (maticniBroj.length() != 13){
//				throw new NumberFormatException ();
//			}
//			for (int i = 0; i < 13; i++) {
//				brojevi[i] = Character.digit(maticniBroj.charAt(i), 10);
//			}return true;
//		} catch (NumberFormatException e){
//			return false;
//		}
//	}
	
	public void PostaviDatumRodjenja (){
		d.setDan(brojevi[0]*10+brojevi[1]);
		d.setMesec(brojevi[2]*10+brojevi[3]);
		d.setGodina(1000+brojevi[4]*100+brojevi[5]*10+brojevi[6]);
		d.setMesecString();
	}
	
	public int vratiDan (){
		return d.getDan();
	}
	
	public int vratiMesec (){
		return d.getMesec();
	}
	
	public int vratiGodinu (){
		return d.getGodina();
	}
	
	public void postaviPol (){
		int verifikator = brojevi[9]*100 + brojevi[10]*10 + brojevi[11];
		if (verifikator >=000 && verifikator <=499) {
			p.setPol("Muski");
		}else{
			p.setPol("Zenski");
		}
	}
	
	public String vratiPol (){
		return p.getPol();
	}
	
	public int mesto (int a){
		return brojevi[a];
	}
	
	public String vratiMesecString (){
		return d.getMesecString();
	}

	public void nadjiLokaciju (){
		lok.setRegion((brojevi[7]*10+brojevi[8]));
		
		}
	
	public String vratiRegion (){
		return lok.getRegion();
	}
	
	public String vratiDrzavu (){
		lok.setSifraDrzave((brojevi[7]*10+brojevi[8]));
		lok.setDrzava();
		return lok.getDrzava();
	}
	
	public String vratiPokarajinu (){
		return lok.getPokrajina();
	}
}
