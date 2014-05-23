package ñba;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel {
     List<Jugadores> list;
    
    public void setDataList(List<Jugadores> list){
        this.list = list;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Dorsal";
            case 1:
                return "Nombre";
            case 2:
                return "Apellidos";
            case 3:
                return "Posición";
            case 4:
                return "Equipo";
            case 5:
                return "Sueldo";
            default:
                return "";
        }
    }
    
    
    
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Jugadores jugador = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return jugador.getDorsal();
            case 1:
                return jugador.getNombre();
            case 2:
                return jugador.getApellidos();
            case 3:
                return jugador.getPosicion();
            case 4:
                return jugador.getIdEquipo();
            case 5:
                return jugador.getSueldo();
            default:
                return null;
        }
    }
    
}
