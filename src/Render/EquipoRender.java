package Render;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import ñba.Equipo;
import ñba.Equipo;
public class EquipoRender extends DefaultTableCellRenderer {
    public EquipoRender() {
        setHorizontalAlignment(SwingConstants.LEFT);
    }
    @Override
    public void setValue(Object aValue) {
        Object equipo = aValue;
        if ((aValue != null) && (aValue instanceof Equipo)) {
            Equipo equipo1 = (Equipo) aValue;
            equipo = equipo1.getEquipo();
        }
        super.setValue(equipo);
    }
}
