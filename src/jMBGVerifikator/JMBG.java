package jMBGVerifikator;

import java.util.Scanner;

public class JMBG {
	
	String maticniBroj = "2105991710136";
	int [] brojevi = new int[13];
	DatumJMBG d = new DatumJMBG();
	
	public void unosJMBGa (){
		Scanner sc = new Scanner(System.in);
				
		try {
			System.out.println("Unesite JMBG:");
			String maticniBroj = sc.nextLine();
			
			if (maticniBroj.length() != 13){
				throw new NumberFormatException ();
			}
			for (int i = 0; i < 13; i++) {
				brojevi[i] = Character.digit(maticniBroj.charAt(i), 10);
				
//		drugi nacin za pravljenje niza
//				String a = maticniBroj.substring(i, i+1);
//				brojevi[i] = Integer.parseInt(a);
			}
		} catch (NumberFormatException e){
			System.err.println("Greska. Morate uneti 13-cifren broj");
		}
	}
	
	public void proveraIspisaDatuma (){
		System.out.println("Dan je: " + d.getDan());
	}
	
	public void datumRodjenja (){
		d.setDan(brojevi[0]*10+brojevi[1]);
		d.setMesec(brojevi[2]*10+brojevi[3]);
		d.setGodina(1000+brojevi[4]*100+brojevi[5]*10+brojevi[6]);
	}

	public void proveraJMBGa (){
		int k = (7*(brojevi[0]+brojevi[6])+6*(brojevi[1]+brojevi[7])
				+5*(brojevi[2]+brojevi[8])+4*(brojevi[3]+brojevi[9])
				+3*(brojevi[4]+brojevi[10])+2*(brojevi[5]+brojevi[11]))%11;
		if ((11-k)!= brojevi[12]) {
			System.err.println("Proverite da li ste ispravno uneli JMBG");
		}else{
			System.out.println("JMBG postoji");
		}
	}
}
