import java.io.File;
/**
 * <<Class summary>>
 *
 * @author Aaron Foltz
 * @version $Rev$
 */
public final class ImageFilter extends javax.swing.filechooser.FileFilter{

    /**
     * ImageFilter constructor
     */
    public ImageFilter() {
        System.out.println("HI");

        
    }

    public boolean accept(File file){
        if(file.isDirectory()){
            return true;
        }
        if(file.toString().endsWith(".jpg") || file.toString().endsWith(".tiff")
                || file.toString().endsWith(".tif") || file.toString().endsWith(".gif")
                || file.toString().endsWith(".jpeg") || file.toString().endsWith(".png")){
            return true;
        }
        return false;

    }
    public String getDescription(){
        return "Images";
    }
}
