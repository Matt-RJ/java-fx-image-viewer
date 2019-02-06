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
	
	// A gray scale version of the original image
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
				
				double pixelRed = pixelColor.getRed();
				double pixelGreen = pixelColor.getGreen();
				double pixelBlue = pixelColor.getBlue();
				double pixelGray = (pixelRed + pixelGreen + pixelBlue)/3;
				Color grayColor = new Color(pixelGray,
											pixelGray,
											pixelGray,pixelColor.getOpacity());
				
				pw.setColor(x, y, grayColor);
			}
		}
		
		grayScaleImage = processedImage;
	}
	
	/**
	 * Multiplies an image's RGBA values to change color intensity - 0.0 disables a color,
	 * 1.0 leaves the color as in the original image.
	 * @param image - The image to alter
	 * @param r - The multiplier for red
	 * @param g - The multiplier for green
	 * @param b - The multiplier for blue
	 * @param a - The multiplier for opacity
	 * @return A color-altered version of the original image
	 */
	public static Image multiplyColor(Image image, double r, double g, double b, double a) {
		WritableImage processedImage = new WritableImage(
				(int) image.getWidth(), (int) image.getHeight());
		
		PixelWriter pw = processedImage.getPixelWriter();
		PixelReader pr = image.getPixelReader();
		
		// Updates the colour of every pixel in the image individually
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				Color pixelColor = pr.getColor(x, y);
				
				double pixelRed = pixelColor.getRed() * r;
				double pixelGreen = pixelColor.getGreen() * g;
				double pixelBlue = pixelColor.getBlue() * b;
				double pixelOpacity = pixelColor.getOpacity() * a;
				pw.setColor(x, y, new Color(pixelRed, pixelGreen, pixelBlue, pixelOpacity));
			}
		}
		
		return processedImage;
	}
}
