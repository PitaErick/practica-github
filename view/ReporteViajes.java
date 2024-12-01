package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class ReporteViajes extends JPanel {
    private JTable tablaClientes;
    private static DefaultTableModel modeloTabla;

    public ReporteViajes() {
        setLayout(new BorderLayout());

        // Modelo de la tabla
        String[] columnas = { "Codigo", "Destino", "Nro Plaza", "Precio", "Fecha Salida", "Fecha Retorno" };
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaClientes = new JTable(modeloTabla);

        // Agregar la tabla al panel con scroll
        JScrollPane scrollPane = new JScrollPane(tablaClientes);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
}
