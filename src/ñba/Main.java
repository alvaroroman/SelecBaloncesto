/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ñba;

import Render.SueldoRender;
import Render.EquipoRender;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Alvaro
 */
public class Main extends javax.swing.JFrame {
    ModeloTabla modelo;
    int selectedRow;
    boolean editarregis = false;
    
public void guardarNuevo(){
        Jugadores jugador = new Jugadores();
        panelJugadores1.setJugador(jugador);
        
        panelJugadores1.setData();
        
        
        entityManager2.getTransaction().begin();
        //Almacenar el objeto en la BD
        entityManager2.persist(jugador);
        entityManager2.getTransaction().commit();

        //Añadir el objeto al final de la lista de datos
        list2.add(jugador);
        //Informar al JTable que se ha insertado una fila al final
        modelo.fireTableRowsInserted(list2.size()-1, list2.size()-1);
    }
    
    public void guardarModificado(){
        //Obtener el índice de la fila seleccionada en la tabla
        selectedRow = jTable1.getSelectedRow();
        //Obtener el objeto desde la lista de datos, conociendo su posición
        Jugadores jugador = list2.get(selectedRow);
        panelJugadores1.setData();  
        entityManager2.getTransaction().begin();
        //Almacenar el objeto en la BD
        entityManager2.merge(jugador);
        entityManager2.getTransaction().commit();

        //Añadir el objeto al final de la lista de datos
        list2.set(selectedRow, jugador);
        //Informar al JTable que se ha modificado la fila seleccionada
        modelo.fireTableRowsUpdated(selectedRow, selectedRow);
    }
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        panelJugadores1.setEditable(false);
        // Cambiar icono de la aplicación
        setIconImage(new ImageIcon(getClass().getResource("/imagen/feb.png")).getImage());
        // Color al panel
        // rootPane.getContentPane().setBackground(new Color(223,64,64));
        
        //Control acceso de usuarios
        //Cargar archivo properties
        Properties properties = new Properties();
        String PROPERTIES_FILE = "properties.properties";
        try {
             properties.load(new BufferedReader(new FileReader(PROPERTIES_FILE)));
        } catch (IOException ex) {
            Logger.getLogger(AccesoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
        
        // Asignar la lista de datos a la tabla
        modelo = new ModeloTabla();
        modelo.setDataList(list2);
        jTable1.setModel(modelo);
        // Dar formato a los precios
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new EquipoRender());
        // Solo se permite seleccionar un registro
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new SueldoRender());
        //jTable1.getColumnModel().getColumn(3).setCellRenderer(new ImagenRender());
        // Detectar cambios de seleccion
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            
            @Override 
            public void valueChanged(ListSelectionEvent e) {
                int indiceFilaSeleccionada = jTable1.getSelectedRow();
                if(indiceFilaSeleccionada>-1){
                Jugadores jugador1 = list2.get(indiceFilaSeleccionada);
                panelJugadores1.setJugador(jugador1);
                panelJugadores1.showdata();
                
                }
            }
            
            
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager2 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("_BAPU").createEntityManager();
        query2 = java.beans.Beans.isDesignTime() ? null : entityManager2.createQuery("SELECT j FROM Jugadores j");
        list2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : query2.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelJugadores1 = new ñba.PanelJugadores();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Selección Española de Baloncesto");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/nuevo.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/editar.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/borrar.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/guardar-archivo-icono-6713-64.png"))); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/españa.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelJugadores1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelJugadores1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        panelJugadores1.cleanData();
        panelJugadores1.setEditable(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(selectedRow>-1){
            editarregis = true;
            panelJugadores1.setEditable(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        selectedRow = jTable1.getSelectedRow(); 
        if(selectedRow>-1){
            
            //Obtener el objeto desde la lista de datos, conociendo su posición
            Jugadores jugador1 = list2.get(selectedRow);
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea eliminar "+jugador1.getNombre()+"?", "Borrar Equipo", JOptionPane.OK_CANCEL_OPTION);
            if(respuesta == JOptionPane.OK_OPTION){            
            //Iniciar una transacción con la BD
            entityManager2.getTransaction().begin();
            //Eliminar el objeto
            entityManager2.remove(jugador1);
            //Finalizar la transacción actualizando la BD
            entityManager2.getTransaction().commit();
            
            
            //Eliminar el objeto de la lista de datos 
            list2.remove(jugador1);
            //Informar al JTable que se ha eliminado una fila
            modelo.fireTableRowsDeleted(selectedRow, selectedRow);
            panelJugadores1.cleanData();
            }
        }else {
                JOptionPane.showMessageDialog(this, "Debes seleccionar un equipo","Error al borrar",JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(editarregis == false){
            guardarNuevo();
        } else {
            guardarModificado();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private java.util.List<Jugadores> list2;
    private ñba.PanelJugadores panelJugadores1;
    private javax.persistence.Query query2;
    // End of variables declaration//GEN-END:variables
}
