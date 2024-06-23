/********************************************************************************************
 *   COPYRIGHT (C) 2024 CREVAVI TECHNOLOGIES PVT LTD
 *   The reproduction, transmission or use of this document/file or its
 *   contents is not permitted without written authorization.
 *   Offenders will be liable for damages. All rights reserved.
 *---------------------------------------------------------------------------
 *   Purpose:  Main class to launch JavaFX application
 *   Project:  MediaPlayerDemo
 *   Platform: Cross-platform (Windows, macOS, Linux)
 *   Compiler: JDK-22
 *   IDE:      Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)
 *	           Version: 2024-03 (4.31.0)
 *             Build id: 20240307-1437
 ********************************************************************************************/

package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Main class for the JavaFX application that sets up the primary stage and
 * loads the main FXML file.
 */
public class Main extends Application {

	/**
	 * The start method is the main entry point for all JavaFX applications. It sets
	 * up the primary stage and loads the main FXML layout.
	 *
	 * @param primaryStage the primary stage for this application, onto which the
	 *                     application scene can be set.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			// Load the main FXML file
			Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));

			// Create a scene with the loaded FXML layout
			Scene scene = new Scene(root);

			// Add the application CSS stylesheet to the scene
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			// Set the scene to the primary stage
			primaryStage.setScene(scene);

			// Show the primary stage
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The main method is ignored in correctly deployed JavaFX applications. main()
	 * serves only as fallback in case the application can not be launched through
	 * deployment artifacts, e.g., in IDEs with limited FX support.
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
