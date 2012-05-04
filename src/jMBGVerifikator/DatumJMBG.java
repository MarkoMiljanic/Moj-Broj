package jMBGVerifikator;

public class DatumJMBG {

	private int godina;
	private int mesec;
	private int dan;
	private String mesecString;
	
	
	
	public String getMesecString() {
		return mesecString;
	}
	public void setMesecString() {
		switch (mesec){
		case 1: mesecString = "Januar";
			break;
		case 2: mesecString = "Februar";
		break;
		case 3: mesecString = "Mart";
		break;
		case 4: mesecString = "April";
		break;
		case 5: mesecString = "Maj";
		break;
		case 6: mesecString = "Jun";
		break;
		case 7: mesecString = "Jul";
		break;
		case 8: mesecString = "Avgust";
		break;
		case 9: mesecString = "Septembar";
		break;
		case 10: mesecString = "Oktobar";
		break;
		case 11: mesecString = "Novembar";
		break;
		case 12: mesecString = "Decembar";
		break;
		}
	}
	public int getGodina() {
		return godina;
	}
	public void setGodina(int godina) {
		this.godina = godina;
	}
	public int getMesec() {
		return mesec;
	}
	public void setMesec(int mesec) {
		this.mesec = mesec;
	}
	public int getDan() {
		return dan;
	}
	public void setDan(int dan) {
		this.dan = dan;
	}
	
	
}
