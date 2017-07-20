package dataType;

/**
 * Klasa odgovorna za kreiranje kolona.
 *
 * @author G6
 */
public class Column 
{
	private String kod;
	private int grupa;
	private String ime;
	private boolean nullable;
	private boolean primarniKljuc;
	private int velicina;
	private String tipPodatka;
	private String refKolona;
	private String refTabela;
	
	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public int getGrupa() {
		return grupa;
	}

	public void setGrupa(int grupa) {
		this.grupa = grupa;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	public boolean isPrimarniKljuc() {
		return primarniKljuc;
	}

	public void setPrimarniKljuc(boolean primarniKljuc) {
		this.primarniKljuc = primarniKljuc;
	}

	public int getVelicina() {
		return velicina;
	}

	public void setVelicina(int velicina) {
		this.velicina = velicina;
	}

	public String getTipPodatka() {
		return tipPodatka;
	}

	public void setTipPodatka(String tipPodatka) {
		this.tipPodatka = tipPodatka;
	}

	public String getRefKolona() {
		return refKolona;
	}

	public void setRefKolona(String refKolona) {
		this.refKolona = refKolona;
	}

	public String getRefTabela() {
		return refTabela;
	}

	public void setRefTabela(String refTabela) {
		this.refTabela = refTabela;
	}
}
