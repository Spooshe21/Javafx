/********************************************************************************************
 *   COPYRIGHT (C) 2024 CREVAVI TECHNOLOGIES PVT LTD
 *   The reproduction, transmission or use of this document/file or its
 *   contents is not permitted without written authorization.
 *   Offenders will be liable for damages. All rights reserved.
 *---------------------------------------------------------------------------
 *   Purpose:  MainController.java
 *   Project:  JavaFX Media Player with Volume Control
 *   Platform: Cross-platform (Windows, macOS, Linux)
 *   Compiler: JDK-22
 *   IDE:      Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)
 *	           Version: 2024-03 (4.31.0)
 *             Build id: 20240307-1437
 ********************************************************************************************/

package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * Controller class for managing media playback in a JavaFX application.
 * Provides methods to control the media player including play, pause, fast
 * forward, slow motion, reload, start, and end actions. Also includes a volume
 * slider to adjust the volume of the media player.
 */
public class MainController implements Initializable {
	@FXML
	private MediaView mv;
	private MediaPlayer mp;
	private Media me;
	@FXML
	private Slider volumeSlider;

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the FXML file has been loaded. It sets up the media player, binds the media
	 * view's properties to the scene, and configures the volume slider.
	 *
	 * @param location  the location used to resolve relative paths for the root
	 *                  object, or null if the location is not known.
	 * @param resources the resources used to localize the root object, or null if
	 *                  the root object was not localized.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String path = new File("src/media/birds.mp4").getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mv.setMediaPlayer(mp);

		DoubleProperty width = mv.fitWidthProperty();
		DoubleProperty height = mv.fitHeightProperty();
		width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));

		volumeSlider.setValue(mp.getVolume() * 100);
		volumeSlider.valueProperty().addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable observable) {
				mp.setVolume(volumeSlider.getValue() / 100);
			}
		});
	}

	/**
	 * Handles the play action to start or resume media playback.
	 *
	 * @param event the action event triggered by the play button.
	 */
	public void play(ActionEvent event) {
		mp.play();
		mp.setRate(1);
	}

	/**
	 * Handles the pause action to pause media playback.
	 *
	 * @param event the action event triggered by the pause button.
	 */
	public void pause(ActionEvent event) {
		mp.pause();
	}

	/**
	 * Handles the fast action to play media at double speed.
	 *
	 * @param event the action event triggered by the fast forward button.
	 */
	public void fast(ActionEvent event) {
		mp.setRate(2);
	}

	/**
	 * Handles the slow action to play media at half speed.
	 *
	 * @param event the action event triggered by the slow motion button.
	 */
	public void slow(ActionEvent event) {
		mp.setRate(0.5);
	}

	/**
	 * Handles the reload action to restart media playback from the beginning.
	 *
	 * @param event the action event triggered by the reload button.
	 */
	public void reload(ActionEvent event) {
		mp.seek(mp.getStartTime());
		mp.play();
	}

	/**
	 * Handles the start action to seek to the start of the media and stop playback.
	 *
	 * @param event the action event triggered by the start button.
	 */
	public void start(ActionEvent event) {
		mp.seek(mp.getStartTime());
		mp.stop();
	}

	/**
	 * Handles the last action to seek to the end of the media and stop playback.
	 *
	 * @param event the action event triggered by the last button.
	 */
	public void last(ActionEvent event) {
		mp.seek(mp.getTotalDuration());
		mp.stop();
	}
}
