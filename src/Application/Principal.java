package Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Principal extends Application {
	
	private static String url = "jdbc:mysql://ls-0f19f4268096a452a869b6f8467bc299c51da519.cz6cgwgke8xd.eu-west-3.rds.amazonaws.com:3306/db0072718"; // URL de connexion
	private static String utilisateur = "user0072718"; // Remplacez par votre nom d'utilisateur
	private static String motDePasse = "Yf3IgyBsOPa34WR"; // Remplacez par votre mot de passe
	
	private static Connection connexion  ;
	private static ResultSet resultSet;
	private static Statement statement;
	
	
	
	private static String _matricule ;
	private static  String nom ;
	private static String prenom ;
	private static  Double moyenne ;
	private static String datenaiss ;
	private static String ecole ;
	
	private static AnchorPane root;
	private static Label label1 ;
	private static VBox vbox1;
	private static Button button1;
	private static Button button2;
	private static Label label3;
	private static TextField inputMatricule;
	private static Label label2;
	private static Button annuler;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
  
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane root = new AnchorPane();
		 label1 = new Label("CONSULTER VOTRE RESULTAT ICI".toUpperCase());
		vbox1 = new VBox(10);
		 inputMatricule = new TextField();
		 button1 = new Button("VALIDER".toUpperCase());
		 button2 = new Button("VOIR PLUS".toUpperCase());//bouton dAffichage de la decision selon la moyenne
		 label2 = new Label(); // Affiche la decision selon la moyenne
		 label3 = new Label(); 
		 annuler= new Button("annuler".toUpperCase());
		
		vbox1.setAlignment(Pos.CENTER);
		vbox1.setPadding(new Insets(25));
		vbox1.getChildren().addAll(label1, inputMatricule, button1 ,label2 ,button2, label3,annuler);
		
		root.getChildren().add(vbox1);
		
		
		button1.setPadding(new Insets(10));
		button1.setOnAction(event->{
			
			deciReturn(inputMatricule.getText());
		});
		
		button2.setPadding(new Insets(10));
		button2.setOnAction(event->{
			
			detail();
		});
		
		annuler.setOnAction(event->{
			
			primaryStage.close();
		});
		

		AnchorPane.setTopAnchor(vbox1, 20.0);
		AnchorPane.setRightAnchor(vbox1, 20.0);
		AnchorPane.setBottomAnchor(vbox1, 20.0);
		AnchorPane.setLeftAnchor(vbox1, 20.0);
		
		
		Scene scene = new Scene(root, 700, 400);
		
		
		primaryStage.show();
		primaryStage.setTitle("CONSULTATION DES RESULTATS");
		primaryStage.setScene(scene);
		
	}
	
	public void MonModal(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText(null); // Pas de sous-titre
		alert.setContentText(message);

		// Affichage de l'alerte
		alert.showAndWait();
	}
	
	
	public static void detail() {
		connexBD();
		label3.setText("Nom et prenom: "+nom+" "+prenom+"\n"+"Date de naissance: "+datenaiss+"\n"+"Moyenne: "+moyenne+"\n"+"Ecole: "+ecole+"\n");
	}
	
	
	public static void deciReturn(String matricule) {
		
		connexBD();
		try {
			statement = connexion.createStatement();
			// Exécuter une requête SQL pour récupérer les données
	        String requete = "SELECT * FROM etudiant where matricule="+matricule;
	         resultSet = statement.executeQuery(requete);

	          // Parcourir les résultats
	          while (resultSet.next()) {
		            _matricule = resultSet.getString("matricule");
		             nom = resultSet.getString("nom");
		            prenom = resultSet.getString("prenom");
		            moyenne = resultSet.getDouble("moyenne");
		             datenaiss = resultSet.getString("datenaiss");
		             ecole = resultSet.getString("ecole");}
	          
	          if( moyenne >= 10) {
	        	  label2.setText("Succès");
	        	  label2.setTextFill(Color.GREEN);
	          }else {
	        	  label2.setText("Echec");
	        	  label2.setTextFill(Color.RED);
	          }
	          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
	}
	
	
	public static void  connexBD() {
		try {
			
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			if (connexion != null) {
                System.out.println("Connexion à la base de données db0072718 réussie !");
            } else {
                System.out.println("Échec de la connexion.");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
