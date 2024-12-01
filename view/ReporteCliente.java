package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ReporteCliente extends JPanel {
    private JTable tablaClientes;
    private static DefaultTableModel modeloTabla;
    private JTextField filtroCedulaField;
    private JButton buscarButton;
    private DefaultTableModel originalModel;

    public ReporteCliente() {
        setLayout(new BorderLayout());

        // Campo de texto para filtrar por cédula
        JPanel filtroPanel = new JPanel(new BorderLayout());
        filtroCedulaField = new JTextField(10);
        ((AbstractDocument) filtroCedulaField.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        filtroPanel.add(new JLabel("Filtrar por Cédula: "), BorderLayout.WEST);
        filtroPanel.add(filtroCedulaField, BorderLayout.CENTER);

        // Botón de búsqueda
        buscarButton = new JButton("Buscar");
        filtroPanel.add(buscarButton, BorderLayout.EAST);
        add(filtroPanel, BorderLayout.NORTH);

        // Modelo de la tabla
        String[] columnas = { "Nombre", "Apellidos", "Cédula", "Correo Electrónico", "Número de Teléfono", "Dirección",
                "Sexo" };
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaClientes = new JTable(modeloTabla);

        // Guardar el modelo original
        originalModel = modeloTabla;

        // Agregar la tabla al panel con scroll
        JScrollPane scrollPane = new JScrollPane(tablaClientes);
        add(scrollPane, BorderLayout.CENTER);

        // Añadir acción al botón de búsqueda
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarPorCedula();
            }
        });
    }

    public static DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    private void filtrarPorCedula() {
        String cedulaFiltro = filtroCedulaField.getText();
        if (cedulaFiltro.isEmpty()) {
            // Si el campo de filtro está vacío, mostrar el modelo original
            tablaClientes.setModel(originalModel);
        } else {
            // Crear un nuevo modelo de tabla filtrado
            Vector<String> columnNames = new Vector<>();
            for (int i = 0; i < originalModel.getColumnCount(); i++) {
                columnNames.add(originalModel.getColumnName(i));
            }
            DefaultTableModel filtradoModel = new DefaultTableModel(columnNames, 0);
            for (int i = 0; i < originalModel.getRowCount(); i++) {
                String cedula = originalModel.getValueAt(i, 2).toString();
                if (cedula.equals(cedulaFiltro)) {
                    Vector<Object> rowData = new Vector<>();
                    for (int j = 0; j < originalModel.getColumnCount(); j++) {
                        rowData.add(originalModel.getValueAt(i, j));
                    }
                    filtradoModel.addRow(rowData);
                }
            }
            if (filtradoModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No se encontraron datos. La cédula ingresada es incorrecta.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                tablaClientes.setModel(originalModel);
            } else {
                tablaClientes.setModel(filtradoModel);
            }
        }
        filtroCedulaField.setText("");
    }

    // Clase interna para filtrar la entrada del campo de texto
    private static class NumericDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr)
                throws javax.swing.text.BadLocationException {
            if (string != null && string.matches("\\d*")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs)
                throws javax.swing.text.BadLocationException {
            if (text != null && text.matches("\\d*")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws javax.swing.text.BadLocationException {
            super.remove(fb, offset, length);
        }
    }
}
