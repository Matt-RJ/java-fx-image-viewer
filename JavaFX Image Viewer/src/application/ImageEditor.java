package application;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;

/**
 * This class stores and processes images for displaying
 * in the GUI window.
 * @author Mantas Rajackas
 *
 */
public class ImageEditor {
	
	// The current image that's loaded in - before any modification
	private static Image originalImage = null;
	
	// The original image's file - Used to obtain properties about the image
	private static File originalImageFile = null;
	
	// A grayscale version of the original image
	private static Image grayScaleImage = null;
	
	
	public static void setOriginalImage(Image newImage) {
		originalImage = newImage;
	}
	public static Image getOriginalImage() {
		return originalImage;
	}
	
	public static void setOriginalImageFile(File newFile) {
		originalImageFile = newFile;
	}
	
	public static File getOriginalImageFile() {
		return originalImageFile;
	}
	
	public static void setGrayScaleImage(Image newGrayScaleImage) {
		grayScaleImage = newGrayScaleImage;
	}
	public static Image getGrayScaleImage() {
		return grayScaleImage;
	}
	
	
	// TODO: Image processing methods
	
	/**
	 * Converts an image to grayscale
	 * @param imageToConvert - The image to convert to grayscale
	 * @return A grayscale version of imageToConvert
	 */
	public static Image toGrayScale(Image imageToConvert) {
		Image processedImage = imageToConvert;
		
		// TODO: Add processing here
		
		PixelReader pr = imageToConvert.getPixelReader();
		
		return processedImage;
	}
	
}
