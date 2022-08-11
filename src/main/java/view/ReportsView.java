
package view;

import controller.ReportsController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.vo.ComprasVo;
import model.vo.LideresVo;
import model.vo.ProyectosVo;

public class ReportsView extends JFrame implements ActionListener {
    private ReportsController controller;
    private JMenuBar mMenuBar;
    private JMenu menu;
    private JMenuItem it1,it2,it3;
    private JTable table;
    private DefaultTableModel modelo;
    private JLabel lblConsulta,lblTitulo;

    
    public ReportsView(){
        controller = new ReportsController();
        menu();
        etiqueta1();
        etiqueta2();
        tabla();
    }
    
    
    public void tabla(
    ){
        table = new JTable(modelo);
        table.setPreferredScrollableViewportSize(new Dimension(600,300));
        add(table);
        JScrollPane pane = new JScrollPane(table);
        add(pane);
    }
    
    public void menu(){
        mMenuBar = new JMenuBar();
        setJMenuBar(mMenuBar);
        menu = new JMenu("Consultas");
        mMenuBar.add(menu);
        it1 = new JMenuItem("Líderes");
        it2 = new JMenuItem("Proyectos");
        it3 = new JMenuItem("Compras");
        menu.add(it1);
        menu.add(it2);
        menu.add(it3);
        it1.addActionListener(this);
        it2.addActionListener(this);
        it3.addActionListener(this);
    }
    
    public void etiqueta1(){
      lblTitulo = new JLabel("Consultas reto 5");
      lblTitulo.setPreferredSize(new Dimension(400,30));
      lblTitulo.setFont(new Font("Arial",Font.BOLD,20));
      add(lblTitulo);
    }
    
    public void etiqueta2(){
      lblConsulta = new JLabel();
      lblConsulta.setPreferredSize(new Dimension(600,30));
      lblConsulta.setFont(new Font("Arial",Font.BOLD,14));
      add(lblConsulta);
    }
  
    public void lideres() throws SQLException {
        var lideres = controller.listarLideres();
        modelo = new DefaultTableModel();
        modelo.addColumn("Id Lider");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Dirección");
        for(LideresVo lider:lideres){
            Object[] fila = new Object[4];
            fila[0]= lider.getIdLider();
            fila[1]= lider.getNombre();
            fila[2]=lider.getPrimerApellido();
            fila[3]= lider.getResidencia();
            modelo.addRow(fila);
        } 
        table.setModel(modelo);
        modelo.fireTableDataChanged();
    }
    
      public void proyectos() throws SQLException {
        var proyectos = controller.listarProyectos();
        modelo = new DefaultTableModel();
        modelo.addColumn("Id Proyecto");
        modelo.addColumn("Constructora");
        modelo.addColumn("# Habitaciones");
        modelo.addColumn("Ciudad");
        for(ProyectosVo proyecto:proyectos){
            Object[] fila = new Object[4];
            fila[0]= proyecto.getIdProyecto();
            fila[1]= proyecto.getConstructora();
            fila[2]=proyecto.getNumHabitaciones();
            fila[3]= proyecto.getCiudad();
            modelo.addRow(fila);
        } 
        table.setModel(modelo);
        modelo.fireTableDataChanged();
        
        
    } public void compras() throws SQLException {
        var compras = controller.listarCompras();
        modelo = new DefaultTableModel();
        modelo.addColumn("Id Compra");
        modelo.addColumn("Constructora");
        modelo.addColumn("Banco");
        for(ComprasVo compra:compras){
            Object[] fila = new Object[3];
            fila[0]= compra.getIdCompra();
            fila[1]= compra.getConstructora();
            fila[2]=compra.getBancoVinculado();
            modelo.addRow(fila);
        } 
        table.setModel(modelo);
        modelo.fireTableDataChanged();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == it1) {
            try {
                lideres();
                lblConsulta.setText("Consulta de Líderes");
            } catch (SQLException c) {
                System.out.println("Error");
            }
        }

        if (e.getSource() == it2) {
            try {
                
                proyectos();
                lblConsulta.setText("Consulta de Proyecto");
            } catch (SQLException c) {
                System.out.println("Error");
            }
        }
        if (e.getSource() == it3) {
            try {
                
                compras();
                lblConsulta.setText("Consulta de Compras");
            } catch (SQLException c) {
                System.out.println("Error");
            }
        }
    }
}
