import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * <<Class summary>>
 *
 * @author Aaron Foltz
 * @version $Rev$
 */
public final class RootGUI extends JFrame{
	BufferedImage img;
	ImageIcon image;
	int scale = 1;
	ImageLabel il = new ImageLabel(img);

	// {{{ Gui constructor
    /**
     * 
     */
    public RootGUI() {
		JMenuBar menu = new JMenuBar();
		final JPanel panel = new JPanel();
		JButton open = new JButton("Open file");
		JButton button = new JButton("HI");


        final JLabel imageLabel = new JLabel();
        final JFileChooser chooser = new JFileChooser();
		final JScrollPane jsp = new JScrollPane();

		this.setName("Croppr");
		this.setDefaultLookAndFeelDecorated(false);
	//	this.setJMenuBar(menu);
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

		panel.setPreferredSize(new Dimension(900,650));
		panel.setBackground(Color.white);
		


		jsp.setPreferredSize(new Dimension(900, 650));

		
		
		/*********************************************
		 *		       Layout Management	   		 *
		 *********************************************/
		this.setLayout(new GridBagLayout());
		GridBagConstraints imageConstraint = new GridBagConstraints();
		GridBagConstraints buttonConstraint = new GridBagConstraints();
		GridBagConstraints sliderConstraints = new GridBagConstraints();
		imageConstraint.gridx = 0;
		imageConstraint.gridy = 0;
		imageConstraint.gridheight = 2;
		imageConstraint.gridwidth = 2;

		buttonConstraint.gridx = 2;
		buttonConstraint.gridy = 0;

		sliderConstraints.gridx = 0;
		sliderConstraints.gridy = 2;
		sliderConstraints.ipadx = 300;
		sliderConstraints.gridwidth = 2;

		this.getContentPane().add(jsp, imageConstraint);
		jsp.setViewportView(il);
		this.getContentPane().add(open, buttonConstraint);
		this.getContentPane().add(il.getSlider(), sliderConstraints);


		//this.getContentPane().add(jsp, image);
		this.pack();
		this.setVisible(true);

		open.addActionListener(new ActionListener() {

		 
		            public void actionPerformed(ActionEvent e)
		            {
		                //Execute when button is pressed

						chooser.addChoosableFileFilter(new ImageFilter());
						int returnVal = chooser.showOpenDialog(panel);
						System.out.println(returnVal);
						try {
                            System.out.println(chooser.getSelectedFile().toString());
							img = ImageIO.read(new File(chooser.getSelectedFile().toString()));
							image = new ImageIcon(img);
							
							System.out.println(image.getIconHeight() + " " + image.getIconWidth());
                            imageLabel.setIcon(image);
							imageLabel.setPreferredSize(new Dimension(25, 100));
							jsp.setViewportView(imageLabel);
							jsp.revalidate();

							validate();
						}
						catch (Exception ex) { 
							ex.printStackTrace();
						}
						
		            }
		        });
    }

	/*public void paint(Graphics g) {
		System.out.println("HI");
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		System.out.println(img.getHeight() + " " + img.getWidth());
        double x = (img.getWidth() - scale*img.getWidth())/2;
        double y = (img.getHeight() - scale*img.getHeight())/2;
        AffineTransform at = AffineTransform.getTranslateInstance(x,y);
        at.scale(scale, scale);
        g2.drawRenderedImage(img, at);
	}*/
}