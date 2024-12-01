package controller;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.DataModel;
import view.EditarCliente;
import view.RegistroCliente;
import view.ReporteCliente;

public class ClienteController {
    private RegistroCliente registroCliente;

    public ClienteController(RegistroCliente registroCliente) {
        this.registroCliente = registroCliente;
    }

    public String registrarCliente() {
        // Obtener los datos ingresados por el usuario
        String nombre = registroCliente.getNombreField().getText().trim();
        String apellidos = registroCliente.getApellidosField().getText().trim();
        String cedula = registroCliente.getCedulaField().getText().trim();
        String correoElectronico = registroCliente.getCorreoField().getText().trim();
        String telefono = registroCliente.getTelefonoField().getText().trim();
        String direccion = registroCliente.getDireccionField().getText().trim();
        String sexo = (String) registroCliente.getSexoBox().getSelectedItem();
        // Validar los datos
        String smgValidate = smgValidate(false, nombre, apellidos, cedula, correoElectronico, telefono, direccion,
                sexo);
        if (smgValidate == "OK") {
            Cliente cliente = new Cliente(nombre, apellidos, cedula, correoElectronico, telefono, direccion, sexo);
            DataModel.getInstance().getClientes().add(cliente);
            clearForm();
        }
        return smgValidate;
    }

    private static String smgValidate(boolean isEdit, String nombre, String apellidos, String cedula,
            String correoElectronico,
            String telefono, String direccion, String sexo) {
        if (nombre.isEmpty() || apellidos.isEmpty() || cedula.isEmpty() || correoElectronico.isEmpty()
                || telefono.isEmpty()
                || direccion.isEmpty()) {
            return "Todos los campos son obligatorios.";
        }

        if (!nombre.matches("[a-zA-Z ]{1,50}")) {
            return "El nombre solo puede contener letras y debe tener un máximo de 50 caracteres.";
        }

        if (!apellidos.matches("[a-zA-Z ]{1,50}")) {
            return "Los apellidos solo pueden contener letras y deben tener un máximo de 50 caracteres.";
        }

        if (!cedula.matches("\\d{10}")) {
            return "La cedula debe contener exactamente 10 números.";
        }

        if (!correoElectronico.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$") || correoElectronico.length() > 100) {
            return "El correoElectronico electrónico no es válido o supera los 100 caracteres.";
        }

        if (!telefono.matches("\\d{10}")) {
            return "El número de teléfono debe contener exactamente 10 números.";
        }

        if (direccion.length() > 150) {
            return "La dirección no puede superar los 150 caracteres.";
        }

        if (!isEdit) {
            if (verificarUsuarioExistente(cedula)) {
                return "OK";
            } else {
                return "Error: Cedula YA registrada.";
            }
        }
        return "OK";
    }

    public static boolean verificarUsuarioExistente(String cedula) {
        for (Cliente item : DataModel.getInstance().getClientes()) {
            if (item.getCedula().equals(cedula)) {
                return false;
            }
        }
        return true;
    }

    public static String editarCliente() {
        String nombre = EditarCliente.getNombreField().getText().trim();
        String apellidos = EditarCliente.getApellidosField().getText().trim();
        String cedula = EditarCliente.getCedulaField().getText().trim();
        String correoElectronico = EditarCliente.getCorreoField().getText().trim();
        String telefono = EditarCliente.getTelefonoField().getText().trim();
        String direccion = EditarCliente.getDireccionField().getText().trim();
        String sexo = (String) EditarCliente.getSexoBox().getSelectedItem();
        // Validar los datos
        String smgValidate = smgValidate(true, nombre, apellidos, cedula, correoElectronico, telefono, direccion, sexo);
        if (smgValidate == "OK") {
            Cliente cliente = new Cliente(nombre, apellidos, cedula, correoElectronico, telefono, direccion, sexo);
            DataModel.getInstance().getClientes().set(
                    DataModel.getInstance().getClientes().indexOf(EditarCliente.getClienteID()),
                    cliente);
        }
        return smgValidate;

    }

    private void clearForm() {
        registroCliente.getNombreField().setText("");
        registroCliente.getApellidosField().setText("");
        registroCliente.getCedulaField().setText("");
        registroCliente.getCorreoField().setText("");
        registroCliente.getTelefonoField().setText("");
        registroCliente.getDireccionField().setText("");
        registroCliente.getSexoBox().setSelectedIndex(0);

    }

    public static void generarReporteClientes() {
        DefaultTableModel modeloTabla = ReporteCliente.getModeloTabla();
        System.out.println(modeloTabla.getRowCount());
        modeloTabla.setRowCount(0); // Limpiar la tabla
        for (Cliente cliente : DataModel.getInstance().getClientes()) {
            Object[] fila = {
                    cliente.getNombre(),
                    cliente.getApellidos(),
                    cliente.getCedula(),
                    cliente.getCorreoElectronico(),
                    cliente.getNumeroTelefono(),
                    cliente.getDireccion(),
                    cliente.getSexo()
            };
            modeloTabla.addRow(fila);
        }
    }

    public static boolean checkData() {
        try {
            String cedula = JOptionPane.showInputDialog("Ingrese Cedula");
            System.out.println(cedula);
            for (Cliente item : DataModel.getInstance().getClientes()) {
                if (item.getCedula().equals(cedula)) {
                    llenarCampos(item);
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        JOptionPane.showMessageDialog(null, "Dato no Encontrado");
        return false;
    }

    private static void llenarCampos(Cliente cliente) {
        EditarCliente.setClienteID(cliente);
        EditarCliente.getNombreField().setText(cliente.getNombre());
        EditarCliente.getApellidosField().setText(cliente.getApellidos());
        EditarCliente.getCedulaField().setText(cliente.getCedula());
        EditarCliente.getCorreoField().setText(cliente.getCorreoElectronico());
        EditarCliente.getTelefonoField().setText(cliente.getNumeroTelefono());
        EditarCliente.getDireccionField().setText(cliente.getDireccion());
        EditarCliente.getSexoBox().setSelectedIndex(0);
    }

}

/*
 * package controller;
 * 
 * import model.Cliente;
 * import view.ClienteRegistroView;
 * import view.ClienteReporteView;
 * 
 * import javax.swing.*;
 * import javax.swing.table.DefaultTableModel;
 * 
 * import java.awt.event.ActionEvent;
 * import java.awt.event.ActionListener;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 * public class ClienteController {
 * private ClienteRegistroView vistaRegistro;
 * private ClienteReporteView vistaReporte;
 * private List<Cliente> listaClientes;
 * 
 * public ClienteController(ClienteRegistroView vistaRegistro,
 * ClienteReporteView vistaReporte) {
 * this.vistaRegistro = vistaRegistro;
 * this.vistaReporte = vistaReporte;
 * this.listaClientes = new ArrayList<>();
 * 
 * this.vistaRegistro.setVisible(true);
 * this.vistaRegistro.getRegistrarButton().addActionListener(new
 * ActionListener() {
 * 
 * @Override
 * public void actionPerformed(ActionEvent e) {
 * registrarCliente();
 * }
 * });
 * 
 * this.vistaRegistro.getEditarButton().addActionListener(new ActionListener() {
 * 
 * @Override
 * public void actionPerformed(ActionEvent e) {
 * editarCliente();
 * }
 * });
 * }
 * 
 * private void registrarCliente() {
 * String nombre = vistaRegistro.getNombreField().getText();
 * String apellidos = vistaRegistro.getApellidosField().getText();
 * String cedula = vistaRegistro.getCedulaField().getText();
 * String cedula =
 * vistaRegistro.getcedulaField().getText();
 * String numeroTelefono = vistaRegistro.getNumeroTelefonoField().getText();
 * String direccion = vistaRegistro.getDireccionField().getText();
 * String sexo = (String) vistaRegistro.getSexoComboBox().getSelectedItem();
 * 
 * // Validaciones
 * if (nombre.isEmpty() || apellidos.isEmpty() || cedula.isEmpty() ||
 * cedula.isEmpty()
 * || numeroTelefono.isEmpty() || direccion.isEmpty()) {
 * JOptionPane.showMessageDialog(vistaRegistro,
 * "Todos los campos son obligatorios.", "Error",
 * JOptionPane.ERROR_MESSAGE);
 * return;
 * }
 * if (!cedula.matches("\\d{10}")) {
 * JOptionPane.showMessageDialog(vistaRegistro,
 * "Cédula inválida. Debe contener exactamente 10 dígitos.",
 * "Error", JOptionPane.ERROR_MESSAGE);
 * return;
 * }
 * if (!cedula.matches(
 * "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
 * JOptionPane.showMessageDialog(vistaRegistro,
 * "Formato de correoElectronico electrónico inválido.", "Error",
 * JOptionPane.ERROR_MESSAGE);
 * return;
 * }
 * if (!numeroTelefono.matches("\\+?[0-9]*")) {
 * JOptionPane.showMessageDialog(vistaRegistro, "Número de teléfono inválido.",
 * "Error",
 * JOptionPane.ERROR_MESSAGE);
 * return;
 * }
 * 
 * // Registro del cliente
 * Cliente cliente = new Cliente(nombre, apellidos, cedula, cedula,
 * numeroTelefono, direccion, sexo);
 * listaClientes.add(cliente);
 * JOptionPane.showMessageDialog(vistaRegistro,
 * "Cliente registrado con éxito. Nombre de usuario: " +
 * cliente.getNombreUsuario(), "Éxito",
 * JOptionPane.INFORMATION_MESSAGE);
 * }
 * 
 * private void editarCliente() {
 * String cedula = vistaRegistro.getCedulaField().getText();
 * 
 * // Buscar cliente por cédula
 * Cliente cliente = null;
 * for (Cliente c : listaClientes) {
 * if (c.getCedula().equals(cedula)) {
 * cliente = c;
 * break;
 * }
 * }
 * 
 * if (cliente == null) {
 * JOptionPane.showMessageDialog(vistaRegistro, "Cliente no encontrado.",
 * "Error", JOptionPane.ERROR_MESSAGE);
 * return;
 * }
 * 
 * // Actualizar datos del cliente
 * cliente.setNombre(vistaRegistro.getNombreField().getText());
 * cliente.setApellidos(vistaRegistro.getApellidosField().getText());
 * cliente.setcedula(vistaRegistro.getcedulaField().
 * getText());
 * cliente.setNumeroTelefono(vistaRegistro.getNumeroTelefonoField().getText());
 * cliente.setDireccion(vistaRegistro.getDireccionField().getText());
 * cliente.setSexo((String) vistaRegistro.getSexoComboBox().getSelectedItem());
 * 
 * JOptionPane.showMessageDialog(vistaRegistro, "Cliente editado con éxito.",
 * "Éxito",
 * JOptionPane.INFORMATION_MESSAGE);
 * }
 * 
 * public void mostrarReporteClientes() {
 * DefaultTableModel modeloTabla = vistaReporte.getModeloTabla();
 * modeloTabla.setRowCount(0); // Limpiar la tabla
 * 
 * for (Cliente cliente : listaClientes) {
 * Object[] fila = {
 * cliente.getNombre(),
 * cliente.getApellidos(),
 * cliente.getCedula(),
 * cliente.getcedula(),
 * cliente.getNumeroTelefono(),
 * cliente.getDireccion(),
 * cliente.getSexo()
 * };
 * modeloTabla.addRow(fila);
 * }
 * 
 * vistaReporte.setVisible(true);
 * }
 * }
 */