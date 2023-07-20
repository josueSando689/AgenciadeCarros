package CarrosAbstracta;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CochesVentana extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblImagen;
    private JTextArea txtCaracteristicas;
    private HashMap<String, Carros> carrosMap = new HashMap<>();
    private JLabel[] carLabels;
    private String selectedCar;
    private Image originalImage;
    private JTextField txtBuscador; // Agregado el JTextField
    private JButton btnBuscar; // Agregado el JButton
    //Atributos
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtColor;
    private JTextField txtCaballos;
    private JTextField txtPuertas;
    private JTextField txtMotor;
    private JTextField txtImagenPath;
    private JButton btnAgregar;

    public CochesVentana() {
        contentPane = new JPanel();
        setContentPane(contentPane);
        
        // TTULO
        JLabel lblTitulo = new JLabel("AGENCIA DE CARROS DEPORTIVOS");
        lblTitulo.setBounds(33, 50, 500, 20);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 25)); // Tamaño de letras del titulo
        contentPane.add(lblTitulo);

        // BUSCADOR
        txtBuscador = new JTextField();
        txtBuscador.setBounds(860, 555, 225, 30); 
        contentPane.add(txtBuscador);

        // BOTON BUSCADOR
        btnBuscar = new JButton("Buscar carro");
        btnBuscar.setBounds(910, 600, 120,40);
        
        // Labels para los nuevos campos
        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(10, 90, 80, 20);
        contentPane.add(lblMarca);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(10, 120, 80, 20);
        contentPane.add(lblModelo);

        JLabel lblColor = new JLabel("Color:");
        lblColor.setBounds(10, 150, 80, 20);
        contentPane.add(lblColor);

        JLabel lblCaballos = new JLabel("Caballos:");
        lblCaballos.setBounds(10, 180, 80, 20);
        contentPane.add(lblCaballos);

        JLabel lblPuertas = new JLabel("Puertas:");
        lblPuertas.setBounds(10, 210, 80, 20);
        contentPane.add(lblPuertas);

        JLabel lblMotor = new JLabel("Motor:");
        lblMotor.setBounds(10, 240, 80, 20);
        contentPane.add(lblMotor);

        JLabel lblImagenPath = new JLabel("Ruta de la imagen:");
        lblImagenPath.setBounds(10, 270, 150, 20);
        contentPane.add(lblImagenPath);

        // Campos de texto para los nuevos labels
        txtMarca = new JTextField();
        txtMarca.setBounds(180, 90, 150, 20);
        contentPane.add(txtMarca);

        txtModelo = new JTextField();
        txtModelo.setBounds(180, 120, 150, 20);
        contentPane.add(txtModelo);

        txtColor = new JTextField();
        txtColor.setBounds(180, 150, 150, 20);
        contentPane.add(txtColor);

        txtCaballos = new JTextField();
        txtCaballos.setBounds(180, 180, 150, 20);
        contentPane.add(txtCaballos);

        txtPuertas = new JTextField();
        txtPuertas.setBounds(180, 210, 150, 20);
        contentPane.add(txtPuertas);

        txtMotor = new JTextField();
        txtMotor.setBounds(180, 240, 150, 20);
        contentPane.add(txtMotor);

        txtImagenPath = new JTextField();
        txtImagenPath.setBounds(180, 270, 150, 20);
        contentPane.add(txtImagenPath);

        // Botón para agregar el nuevo carro
        btnAgregar = new JButton("Agregar carro");
        btnAgregar.setBounds(180, 300, 150, 30);
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarNuevoCarro();
            }
        });
        contentPane.add(btnAgregar);
        

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreBuscado = txtBuscador.getText();
                Carros carroBuscado = carrosMap.get(nombreBuscado);
                if (carroBuscado != null) {
                    int index = 0;
                    for (Carros car : carrosMap.values()) {
                        if (car == carroBuscado) {
                            lblImagen.setIcon(carLabels[index].getIcon());
                            txtCaracteristicas.setText(car.mostrarCaracteristicas());
                            break;
                        }
                        index++;
                       
                    }
                } else {
                    lblImagen.setIcon(null);
                    txtCaracteristicas.setText("Carro no encontrado.");
                }
            }
            
        });
        contentPane.add(btnBuscar);

        // Aqui se agregan las caracteristicas de los carros y se agerga las localizaciones de las imagenes

        carrosMap.put("Camaro", new Carros("Chevrolet", 2023, "Camaro ZL1", "Azul", "650 Caballos", 2, "V8 supercargado de 6.2L", "/CarrosAbstracta/CAMARO.png"));
        carrosMap.put("Aventador", new Carros("Lamborghini", 2023, "Aventador", "Plateado", "780 Caballos", 2, "V12, 60°, inyección multipunto", "/CarrosAbstracta/LAMBORGHINI.png"));
        carrosMap.put("F150", new Carros("Ferrari", 2023, "458", "Rojo", "570 Caballos", 2, "4.5 V8", "/CarrosAbstracta/FERRARI50.png"));
        carrosMap.put("MustangGt", new Carros("Ford", 2023, "Mustang Gt", "Gris Basltico", "500 Caballos", 2, "V8 de aspiración atmosférica", "/CarrosAbstracta/MUSTANG.png"));
        carrosMap.put("S750", new Carros("Mclaren", 2023, "750S", "Anaranjado/Negro", "751 Caballos", 2, "V8 biturbo", "/CarrosAbstracta/MCCLAREN.png"));
        carrosMap.put("Enzo", new Carros("Ferrari", 2004, "Enzo", "Rojo", "660 Caballos", 2, "V12 a 65° Tipo F140B de 5999 cm³ (6 L; 366,1 plg³)", "/CarrosAbstracta/ENZO.png"));
        carrosMap.put("Audi", new Carros("Audi", 2023, "R8", "Gris crustaceo", "620 Caballos", 2, "V10 atmosférico de 5,2 litros", "/CarrosAbstracta/AUDI.png"));
        carrosMap.put("Porsche", new Carros("Porsche", 2023, "911", "Amarillo", "650 Caballos", 2, "V6 con 385 hp y 450 Nm de torque", "/CarrosAbstracta/PORSCHE.png"));
        carrosMap.put("Bugatti", new Carros("Bugatti", 2023, "Chiron", "Azul/Negro", "1500 Caballos", 2, "W16 de 8 litros en posición centra", "/CarrosAbstracta/BUGATTI.png"));
        carrosMap.put("Jaguar", new Carros("Jaguar", 2023, "f-Type", "Gris", "575 Caballos", 2,"V8 turboalimentado", "/CarrosAbstracta/JAGUAR.png"));
        
        contentPane.setLayout(null);

        // Tamaño imagenes
        int imageSizeWidth = 230;
        int imageSizeHeight = 150;

        // Abajo y arriba de las imagenes
        int startX =500;
        int startY = 35;

        // Espacio entre imagenes
        int spacing =  20;

        int columnas = 3; // Cambiado a 3 columnas

        carLabels = new JLabel[carrosMap.size()];
        int filas = 0;
        int columna = 0;

        for (Carros car : carrosMap.values()) {
            carLabels[filas * columnas + columna] = new JLabel();

            carLabels[filas * columnas + columna].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    // Que aparezca la misma imagen cuando das seleccionar
                    selectedCar = car.getNombre();
                    int finalIndex = 0;
                    lblImagen.setIcon(carLabels[finalIndex].getIcon());
                    txtCaracteristicas.setText(car.mostrarCaracteristicas());
                }
            });
            // Por si las moscas carga bien las imagenes
            try {
                String imagePath = car.getImagenPath();
                ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
                Image image = icon.getImage();

                // Guardar el tamaño original de la imagen
                originalImage = image;

                // Escalar la imagen para que que ya aparezac bienn
                image = image.getScaledInstance(imageSizeWidth, imageSizeHeight, Image.SCALE_SMOOTH);
                carLabels[filas * columnas + columna].setIcon(new ImageIcon(image));
            } catch (Exception e) {
                System.err.println("Error loading image: " + e.getMessage());
            }

            // Calcular la posición de la imagen
            int x = startX + (imageSizeWidth + spacing) * columna;
            int y = startY + (imageSizeHeight + spacing) * filas;

            carLabels[filas * columnas + columna].setBounds(x, y, imageSizeWidth, imageSizeHeight);
            contentPane.add(carLabels[filas * columnas + columna]);

            final int finalIndex = filas * columnas + columna;
            carLabels[filas * columnas + columna].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    lblImagen.setIcon(carLabels[finalIndex].getIcon());
                    txtCaracteristicas.setText(car.mostrarCaracteristicas());
                }
            });

            columna++;

            if (columna == columnas) {
                // Si llegamos al límite de columnas, cambiar a la siguiente fila
                columna = 0;
                filas++;
            }
        }

        lblImagen = new JLabel();
        lblImagen.setBounds(125, 520, imageSizeWidth, imageSizeHeight); // POSISCION DE LA IMAGEN EMERGENTE
        contentPane.add(lblImagen);

        txtCaracteristicas = new JTextArea();
        txtCaracteristicas.setBounds(10, 350, 460, 150); // Tamaño de la ventana emergente que describe los carros
        contentPane.add(txtCaracteristicas);

    }
 
    // LA CLASE MAIN
    public static void main(String[] args) {
        CochesVentana ventana = new CochesVentana();
        ventana.setTitle("Selección de Carros");
        ventana.setSize(1363,800);//Tamaño ventana 
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);  
    }
    
    // Agregar el nuevo coche
    private void agregarNuevoCarro() {
        String marca = txtMarca.getText();
        int año = 2023; // Ya se da por hecho que todos los moedelos son 2023
        String modelo = txtModelo.getText();
        String color = txtColor.getText();
        String caballos = txtCaballos.getText();
        int puertas = Integer.parseInt(txtPuertas.getText());
        String motor = txtMotor.getText();
        String imagenPath = txtImagenPath.getText();

        
        if (marca.isEmpty() || modelo.isEmpty() || color.isEmpty() || caballos.isEmpty() || txtPuertas.getText().isEmpty()
                || motor.isEmpty() || imagenPath.isEmpty()) {
            // Mostramos un mensaje de error si falta algún campo
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos rqueridos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Se agrega al HasMap
        Carros nuevoCarro = new Carros(marca, año, modelo, color, caballos, puertas, motor, imagenPath);
        carrosMap.put(modelo, nuevoCarro);

        txtMarca.setText("");
        txtModelo.setText("");
        txtColor.setText("");
        txtCaballos.setText("");
        txtPuertas.setText("");
        txtMotor.setText("");
        txtImagenPath.setText("");

        // Mostramos un mensaje de éxito
        JOptionPane.showMessageDialog(this, "El nuevo carro ha sido agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        actualizarCarrosEnVentana();
    }
    //Recorre mis carros
    private void actualizarCarrosEnVentana() {
        for (JLabel label : carLabels) {
            contentPane.remove(label);
        }
        int index = 0;
        for (Carros car : carrosMap.values()) {
            carLabels[index].setIcon(new ImageIcon(getClass().getResource(car.getImagenPath())));
            index++;
        }

        // Actulizar ventana
        contentPane.revalidate();
        contentPane.repaint();
    }


}

// EL POLIFORMISMO Y LLENAR LOS METODOS 
abstract class Carro {
    protected String marca;
    protected int año;
    protected String modelo;
    protected String color;
    protected String caballos;
    protected int puertas;
    protected String motor;
    protected String imagen;

    public Carro(String marca, int año, String modelo, String color, String caballos, int puertas, String motor, String imagen) {
        this.marca = marca;
        this.año = año;
        this.modelo = modelo;
        this.color = color;
        this.caballos = caballos;
        this.puertas = puertas;
        this.motor = motor;
        this.imagen = imagen;
    
    }

    public abstract String getImagenPath();

    public abstract String mostrarCaracteristicas();
}

class Carros extends Carro {

    public Carros(String marca, int año, String modelo, String color, String caballos, int puertas, String motor, String imagen) {
        super(marca, año, modelo, color, caballos, puertas, motor, imagen);
    }

    public String getNombre() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getImagenPath() {
        return imagen;
    }

    @Override
    public String mostrarCaracteristicas() {
        String caracteristicas = "Marca: " + marca + "\n" + "Año: " + año + "\n" + "Modelo: " + modelo + "\n" + "Color: "
                + color + "\n" + "Caballos: " + caballos + "\n" + "Puertas: " + puertas + "\n" + "Motor: " + motor + "\n";
        return caracteristicas;
    }
}
