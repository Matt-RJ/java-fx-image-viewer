package application;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

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
	 * Converts an image to grayscale and adds it to the grayScaleImage field
	 * @param imageToConvert - The image to convert to grayscale
	 * @return A grayscale version of imageToConvert
	 */
	public static void toGrayScale(Image image) {
		WritableImage processedImage = new WritableImage(
				(int) image.getWidth(), (int) image.getHeight());
		
		PixelWriter pw = processedImage.getPixelWriter();
		PixelReader pr = image.getPixelReader();
		
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				Color pixelColor = pr.getColor(x, y);
				pw.setColor(x, y, pixelColor.grayscale());	
			}
		}
		
		grayScaleImage = processedImage;
	}
	
	
	
}
