import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * Created by IntelliJ IDEA.
 * User: aaron
 * Date: 4/11/11
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImageLabel extends JLabel {
	int scale = 1;
	BufferedImage image;
	ImageIcon img;
	public ImageLabel(BufferedImage image){
		this.image = image;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        double x = (getWidth() - scale*image.getWidth())/2;
        double y = (getHeight() - scale*image.getHeight())/2;
        AffineTransform at = AffineTransform.getTranslateInstance(x,y);
        at.scale(scale, scale);
        g2.drawRenderedImage(image, at);
  }


	public JSlider getSlider(){
		final JSlider slider = new JSlider(0, 100, 50);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMinorTickSpacing(2);
		slider.setMajorTickSpacing(10);
		slider.setLabelTable(slider.createStandardLabels(10, 0));

		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {
				//To change body of implemented methods use File | Settings | File Templates.
				int value = slider.getValue();

                scale = value;
                revalidate();
                repaint();
			}
		});


		return slider;
	}
}
