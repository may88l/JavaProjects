import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
 
public class UsaFilm {
 
	public static void main(String[] args) throws SQLException {
 
		String url = "jdbc:mysql://localhost:3306/"; 
		String dbName = "home"; 
		String user = "root"; 
		String password = "1234";
 
		Scanner input = new Scanner (System.in);
 
		ArrayList<Film> listaFilm = new ArrayList<Film>();
		int scelta = 0;
 
		do {
			System.out.println("\nCosa vuoi fare? \n[1] Registrare un nuovo film \n[2] Stampare tutti i film \n[3] Ricerca per genere \n[4] Modificare l'anno \n[5] Cancellare il film \n[0] EXIT");
			scelta = input.nextInt();
 
            if (scelta == 1) {  //registrare nuovi film
                Scanner input1 = new Scanner(System.in);

                System.out.print("Inserisci titolo: ");
                String titolo = input1.nextLine();
                System.out.print("Inserisci regista: ");
                String regista = input1.nextLine();
                System.out.print("Inserisci anno: ");
                int anno = input1.nextInt();
                input1.nextLine();
                System.out.print("Inserisci genere: ");
                String genere = input1.nextLine();

                String insertQuery1 = "INSERT INTO film (titolo, regista, anno, genere) VALUES (?, ?, ?, ?)";
                try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
						PreparedStatement stmt = conn.prepareStatement(insertQuery1)) 
				{
                    stmt.setString(1, titolo);
                    stmt.setString(2, regista);
                    stmt.setInt(3, anno);
                    stmt.setString(4, genere);
					
					int rowsAffected = stmt.executeUpdate(); // Esecuzione della query per l'inserimento dei dati
					System.out.println("Numero di righe aggiornate: " + rowsAffected); // Stampa il numero di righe aggiornate
 
				} catch (SQLException e) {  // Gestione dell'eccezione 
					System.out.println("Errore durante l'inserimento dei dati nella tabella 'film':");
					e.printStackTrace();
				}
			}
            
            
			else if (scelta == 2) { //stampare tutti i film
				listaFilm = new ArrayList<Film>();
				String insertQuery2 = "SELECT * FROM Film";
 
				try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(insertQuery2)) {
 
					while (rs.next()) {  // Iterazione sui risultati e lettura dei dati
						int id = rs.getInt("id");
						String titolo = rs.getString("titolo");
						String regista = rs.getString("regista");
						int anno = rs.getInt("anno");
						String genere = rs.getString("genere");
						
						//Creazione di un nuovo oggetto Prodotto e aggiunta alla lista
			            Film newFilm = new Film (id, titolo, regista, anno, genere);
			            listaFilm.add(newFilm);

					}
					for (Film d1 : listaFilm) { // Stampa dei prodotti nella lista
						System.out.println(d1);
					}
				} catch (SQLException e) {
					// Gestione delle eccezioni per la connessione al database o la lettura dei dati
					System.out.println("Errore durante la lettura dei dati dalla tabella 'prodotti':");
					e.printStackTrace();
				}
			}
 
            
			else if (scelta == 3) { //Ricerca per genere
 
				System.out.println("Premi \n[1] per Thriller, \n[2] per Romantico, \n[3] per Azione, \n[4] per Horror, \n[5] per Commedia");
				Scanner input3 = new Scanner (System.in);
				int gen = input3.nextInt();
		
				if (gen == 1) { //suddivisione dei vari generi
					
					String queryRic = "SELECT * FROM Film WHERE genere = (?)";
					String genereFilm = "thriller";
					try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
							PreparedStatement stmt = conn.prepareStatement(queryRic))
					{
						stmt.setString(1, genereFilm);
						ResultSet rs = stmt.executeQuery();
						while (rs.next()) {
							int id = rs.getInt("id");
							String titolo = rs.getString("titolo");
							String regista = rs.getString("regista");
							int anno = rs.getInt("anno");
							String genere = rs.getString("genere");
							System.out.println("Film [id =" + id + ", Titolo = " + titolo + ", Regista = " + regista + ", Anno = " + anno + ", Genere = " + genere +  "]");
						} 
					}
					
					
				} else if (gen == 2) {
					
					String queryRic = "SELECT * FROM Film WHERE genere = (?)";
					String genereFilm = "romantico";
					try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
							PreparedStatement stmt = conn.prepareStatement(queryRic))
					{
						stmt.setString(1, genereFilm);
						ResultSet rs = stmt.executeQuery();
						while (rs.next()) {
							int id = rs.getInt("id");
							String titolo = rs.getString("titolo");
							String regista = rs.getString("regista");
							int anno = rs.getInt("anno");
							String genere = rs.getString("genere");
							System.out.println("Film [id =" + id + ", Titolo = " + titolo + ", Regista = " + regista + ", Anno = " + anno + ", Genere = " + genere +  "]");
						}
					} 
 
					
				} else if (gen == 3) {
					
					String queryRic = "SELECT * FROM Film WHERE genere = (?)";
					String genereFilm = "azione";
					try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
							PreparedStatement stmt = conn.prepareStatement(queryRic))
					{
						stmt.setString(1, genereFilm);
						ResultSet rs = stmt.executeQuery();
						while (rs.next()) {
							int id = rs.getInt("id");
							String titolo = rs.getString("titolo");
							String regista = rs.getString("regista");
							int anno = rs.getInt("anno");
							String genere = rs.getString("genere");
							System.out.println("Film [id =" + id + ", Titolo = " + titolo + ", Regista = " + regista + ", Anno = " + anno + ", Genere = " + genere +  "]");
						}
					} 
					
				} else if (gen == 4) {
					
					String queryRic = "SELECT * FROM Film WHERE genere = (?)";
					String genereFilm = "horror";
					try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
							PreparedStatement stmt = conn.prepareStatement(queryRic))
					{
						stmt.setString(1, genereFilm);
						ResultSet rs = stmt.executeQuery();
						while (rs.next()) {
							int id = rs.getInt("id");
							String titolo = rs.getString("titolo");
							String regista = rs.getString("regista");
							int anno = rs.getInt("anno");
							String genere = rs.getString("genere");
							System.out.println("Film [id =" + id + ", Titolo = " + titolo + ", Regista = " + regista + ", Anno = " + anno + ", Genere = " + genere +  "]");
						}
					} 
					
					
				} else if (gen == 5) {
					String queryRic = "SELECT * FROM Film WHERE genere = (?)";
					String genereFilm = "commedia";
					try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
							PreparedStatement stmt = conn.prepareStatement(queryRic))
					{
						stmt.setString(1, genereFilm);
						ResultSet rs = stmt.executeQuery();
						while (rs.next()) {
							int id = rs.getInt("id");
							String titolo = rs.getString("titolo");
							String regista = rs.getString("regista");
							int anno = rs.getInt("anno");
							String genere = rs.getString("genere");
							System.out.println("Film [id =" + id + ", Titolo = " + titolo + ", Regista = " + regista + ", Anno = " + anno + ", Genere = " + genere +  "]");
						}
					} 
				} 
 
 
				
 
			} else if (scelta == 4) { //Modificare l'anno
 
				Scanner input1 = new Scanner (System.in);
				System.out.println("Inserisci l'Id del film: ");
				int idFilm = input1.nextInt();
				
				System.out.println("Inserisci l'anno corretto del film: ");
				int modificaAnnoFilm = input1.nextInt();
 
				String insertQuery1 = "UPDATE Film SET anno = ? WHERE id = ?";
 
				try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
						PreparedStatement stmt = conn.prepareStatement(insertQuery1)) 
				{
 
					stmt.setInt(1, modificaAnnoFilm);
					stmt.setInt(2, idFilm);
					
					int rowsAffected = stmt.executeUpdate();  // Esecuzione della query per l'inserimento dei dati
					System.out.println("L'anno del film è stato cambiato");  // Stampa il numero di righe aggiornate
 
				} catch (SQLException e) { // Gestione dell'eccezione
					System.out.println("Errore durante l'inserimento dei dati nella tabella 'film':");
					e.printStackTrace();
				}
				
				
			} else if (scelta == 5) { //Cancellare film 
 
				Scanner input1 = new Scanner (System.in);
				System.out.println("Inserisci l'Id del film da cancellare: ");
				int idFilm = input1.nextInt();
 
				String insertQuery1 = "DELETE FROM Film WHERE id = ?";
				try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
						PreparedStatement stmt = conn.prepareStatement(insertQuery1)) 
				{
					stmt.setInt(1, idFilm);
 
					int rowsAffected = stmt.executeUpdate();  // Esecuzione della query per l'inserimento dei dati
					System.out.println("Il film è stato correttamente rimosso!");  // Stampa il numero di righe aggiornate
 
				} catch (SQLException e) { // Gestione dell'eccezione per la connessione al database o l'esecuzione della query
					System.out.println("Errore durante l'inserimento dei dati nella tabella 'film':");
					e.printStackTrace();
				}
 
			} 
		} while (scelta != 0);
	}}
 