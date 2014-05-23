package Render;
import ñba.Equipo;
import java.awt.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import ñba.Equipo;

public class EquipoListRender implements ListCellRenderer{
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        //Se van a mostrar los elementos en un JLabel, que es el componente habitual en los JList
        DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);
        
        //Convertir el valor recibido (value) al tipo de datos corespondiente
        Equipo equipo1 = (Equipo) value;
        //Crear el texto que se quiere mostrar para cada objeto
        switch(equipo1.getIdEquipo()){
                case 1:
            try {
                renderer.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagen/barcelona.png"))));
            } catch (IOException ex) {
                Logger.getLogger(EquipoRender.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                case 2:
            try {
                renderer.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagen/madrid.png"))));
            } catch (IOException ex) {
                Logger.getLogger(EquipoRender.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                case 3:
            try {
                renderer.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagen/lakers.png"))));
            } catch (IOException ex) {
                Logger.getLogger(EquipoRender.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                case 4:
            try {
                renderer.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagen/minesota.png"))));
            } catch (IOException ex) {
                Logger.getLogger(EquipoRender.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                    case 5:
            try {
                renderer.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagen/portland.png"))));
            } catch (IOException ex) {
                Logger.getLogger(EquipoRender.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                    case 6:
            try {
                renderer.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagen/dallas.png"))));
            } catch (IOException ex) {
                Logger.getLogger(EquipoRender.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                    case 7:
            try {
                renderer.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagen/ocklahoma.png"))));
            } catch (IOException ex) {
                Logger.getLogger(EquipoRender.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                    case 8:
            try {
                renderer.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagen/baskonia.png"))));
            } catch (IOException ex) {
                Logger.getLogger(EquipoRender.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                    case 9:
            try {
                renderer.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagen/memphis.png"))));
            } catch (IOException ex) {
                Logger.getLogger(EquipoRender.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                default:
                    renderer.setIcon(null);     
            }  
        
        renderer.setText(equipo1.getEquipo());
        
        return renderer;
    }
    
}
