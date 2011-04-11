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
	// {{{ Gui constructor
    /**
     * 
     */
    public RootGUI() {
		JMenuBar menu = new JMenuBar();
		final JPanel panel = new JPanel();
		JButton open = new JButton("Open file");
		JButton button = new JButton("HI");
		JSlider slider = new JSlider(0, 100, 50);

        final JLabel imageLabel = new JLabel();
        final JFileChooser chooser = new JFileChooser();
		final JScrollPane jsp = new JScrollPane(imageLabel);

		this.setName("Croppr");
		this.setDefaultLookAndFeelDecorated(false);
	//	this.setJMenuBar(menu);
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

		panel.setPreferredSize(new Dimension(900,650));
		panel.setBackground(Color.white);
		
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMinorTickSpacing(2);
		slider.setMajorTickSpacing(10);
		slider.setLabelTable(slider.createStandardLabels(10, 0));
		System.out.println(slider.getSize());
		//slider.setPreferredSize(slider.getSize());
		//slider.setMinimumSize(new Dimension(20, 200));

		jsp.setPreferredSize(new Dimension(900, 650));

		
		
		/*********************************************
		 *		       Layout Management	   		 *
		 *********************************************/
		this.setLayout(new GridBagLayout());
		GridBagConstraints image = new GridBagConstraints();
		GridBagConstraints buttons = new GridBagConstraints();
		GridBagConstraints sliderConstraints = new GridBagConstraints();
		image.gridx = 0;
		image.gridy = 0;
		image.gridheight = 2;
		image.gridwidth = 2;

		buttons.gridx = 2;
		buttons.gridy = 0;

		sliderConstraints.gridx = 0;
		sliderConstraints.gridy = 2;
		sliderConstraints.ipadx = 300;
		sliderConstraints.gridwidth = 2;

		//sliderConstraints.gridwidth = 2;
		//panel.add(new JLabel(img));
		this.getContentPane().add(jsp, image);
		this.getContentPane().add(open, buttons);
		this.getContentPane().add(slider, sliderConstraints);


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
							//img = new ImageIcon("us.jpg");
                            System.out.println(chooser.getSelectedFile().toString());
							img = ImageIO.read(new File(chooser.getSelectedFile().toString()));

							//img = img.getScaledInstance(900, 600, 1);
							//getClass().getClassLoader().getResource("myimage.jpeg")
                            //imageLabel = new JLabel(new ImageIcon(img));
                            imageLabel.setIcon(new ImageIcon(img));
							//getContentPane().add(new JScrollPane(imageLabel));
							validate();
						}
						catch (Exception ex) { 
							ex.printStackTrace();
						}
						
		            }
		        });
    }

	public void paint(Graphics g) {
	    //super.paintComponent(g); 
	    Graphics2D g2D = (Graphics2D) g;
	    //AffineTransform affT = g2D.getTransform();
	    g2D.scale(100,100);
	    super.paint(g);
	   // g2D.setTransform(affT);
	}
}