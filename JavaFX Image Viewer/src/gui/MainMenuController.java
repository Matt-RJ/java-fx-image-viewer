package gui;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

import application.ImageEditor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainMenuController {
	
	@FXML MenuItem quitMenuItem;
	@FXML MenuItem openImageMenuItem;
	@FXML ImageView imagePanel;
	
	
	// Image Properties
	@FXML Label imageName;
	@FXML Label imageDimensions;
	@FXML Label imagePath;
	@FXML Label imageFileSize;
	
	@FXML
	public void quitProgram(ActionEvent event) {
		System.exit(0);
	}
	
	@FXML
	/**
	 * Opens a file browser window 
	 * @param event
	 */
	public void openImage(ActionEvent event) {
		
		// File browser for selecting image
		FileChooser fc = new FileChooser();
		fc.setTitle("Select an image");
		File imageFile = fc.showOpenDialog(new Stage());
		
		// Stores and displays the image
		ImageEditor.setOriginalImage(new Image(imageFile.toURI().toString()));
		ImageEditor.setOriginalImageFile(imageFile);
		imagePanel.setImage(ImageEditor.getOriginalImage());
		
		displayImageProperties();
		
	}
	
	public void displayImageProperties() {
		File imageFile = ImageEditor.getOriginalImageFile();
		Image image = ImageEditor.getOriginalImage();
		
		// Name
		String name = "Name: " + imageFile.getName();
		imageName.setText(name);
		
		// Dimensions
		String dimensions = "Dimensions: " + (int) image.getWidth() + "x" + (int) image.getHeight();
		imageDimensions.setText(dimensions);
		
		String path = "Path: " + imageFile.getAbsolutePath();
		imagePath.setText(path);
		
		// File Size
		double bytes = imageFile.length();
		double kilobytes = bytes / 1024;
		double megabytes = kilobytes / 1024;
		
		DecimalFormat df = new DecimalFormat("#.##");
		String fileSize = "File Size: " + df.format(megabytes) + " MB";
		imageFileSize.setText(fileSize);
	}
}
