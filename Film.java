
public class Film {
	private int id;
	private String titolo;
	private String regista;
	private int anno;
	private String genere;


	public Film (int id, String titolo, String regista, int anno, String genere) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.titolo = titolo;
		this.regista = regista;
		this.anno = anno;
		this.genere = genere;
	}
	@override
	public String toString() {
		return "Film: id=" + id + ", titolo: " + titolo + ", regista: " + regista + ", anno: " +  anno + ", genere: " + genere;
	}

}
