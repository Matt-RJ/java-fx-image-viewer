package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import application.ImageEditor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainMenuController {
	
	// Menu Bar
	@FXML private MenuItem quitMenuItem;
	@FXML private MenuItem openImageMenuItem;
	@FXML private MenuItem openColorChannelButton;
	
	@FXML private ImageView imagePanel;
	
	// Image Properties
	@FXML private Label imageName;
	@FXML private Label imageDimensions;
	@FXML private Label imagePath;
	@FXML private Label imageFileSize;
	
	@FXML private Button toGrayScaleButton;
	
	// Color Channels
	@FXML private Button showRedChannel;
	@FXML private Button showGreenChannel;
	@FXML private Button showBlueChannel;
	
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
		ImageEditor.setGrayScaleImage(null);
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
	
	public void toGrayScale(ActionEvent event) {
		
		// From gray to normal
		if (imagePanel.getImage().equals(ImageEditor.getGrayScaleImage())) {
			imagePanel.setImage(ImageEditor.getOriginalImage());
		}
		
		// From normal to gray
		else {
			if (ImageEditor.getGrayScaleImage() == null) {
				ImageEditor.toGrayScale(ImageEditor.getOriginalImage());
			}
			imagePanel.setImage(ImageEditor.getGrayScaleImage());
		}
		
	}
	
	/**
	 * Opens the colour channels window, displaying the currently-loaded image
	 * @param event
	 */
	public void openColorChannelWindow(ActionEvent event) {
		
		if (ImageEditor.getOriginalImageFile() != null) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("ColorMenu.FXML"));
				Parent root1 = (Parent) loader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.initStyle(StageStyle.UNDECORATED);
				stage.setTitle("Colour Channels");
				stage.setScene(new Scene(root1));
				stage.show();
				imagePanel.setImage(ImageEditor.getOriginalImage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void showRedChannel(ActionEvent event) {
		
	}
	
	public void showGreenChannel(ActionEvent event) {
		
	}
	
	public void showBlueChannel(ActionEvent event) {
		
	}
	
	
}
