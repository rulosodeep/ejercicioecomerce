package ejemplos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContadorReloj extends JFrame {
    private JLabel contadorLabel;
    private JLabel relojLabel;
    private JTextField incrementoTextField;
    private JButton aplicarIncrementoButton;
    private int contador;
    private int incremento;
    
    public ContadorReloj() {
        // Configuración de la ventana principal
        setTitle("Contador con Reloj");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));  // 4 filas: reloj, contador, campo de texto y botón

        // Inicialización del contador e incremento
        contador = 0;
        incremento = 1;  // Inicia incrementando de 1 en 1

        // Componente para mostrar el contador
        contadorLabel = new JLabel("Contador: " + contador, JLabel.CENTER);
        contadorLabel.setFont(new Font("Serif", Font.BOLD, 20));

        // Componente para mostrar el reloj
        relojLabel = new JLabel("Hora: ", JLabel.CENTER);
        relojLabel.setFont(new Font("Serif", Font.BOLD, 20));

        // Campo de texto para capturar el nuevo valor de incremento
        incrementoTextField = new JTextField("1", 5);

        // Botón para aplicar el nuevo incremento
        aplicarIncrementoButton = new JButton("Aplicar Incremento");
        aplicarIncrementoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aplicarNuevoIncremento();
            }
        });

        // Añadir componentes a la ventana
        add(relojLabel);
        add(contadorLabel);
        add(incrementoTextField);
        add(aplicarIncrementoButton);

        // Iniciar los hilos para el reloj y el contador
        iniciarHiloReloj();
        iniciarHiloContador();

        // Mostrar la ventana
        setVisible(true);
    }

    // Método para iniciar el hilo que actualiza el reloj
    private void iniciarHiloReloj() {
        Thread hiloReloj = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    actualizarReloj();
                    try {
                        Thread.sleep(1000);  // Esperar un segundo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        hiloReloj.start();  // Iniciar el hilo del reloj
    }

    // Método para iniciar el hilo que actualiza el contador
    private void iniciarHiloContador() {
        Thread hiloContador = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    actualizarContador();
                    try {
                        Thread.sleep(1000);  // Esperar un segundo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        hiloContador.start();  // Iniciar el hilo del contador
    }

    // Método para actualizar el valor del contador
    private void actualizarContador() {
        contador += incremento;
        // Actualizar el label del contador en el hilo de la interfaz gráfica
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                contadorLabel.setText("Contador: " + contador);
            }
        });
    }

    // Método para actualizar el texto del reloj
    private void actualizarReloj() {
        // Obtener la hora actual
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        String horaActual = formatoHora.format(new Date());

        // Actualizar el label del reloj en el hilo de la interfaz gráfica
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                relojLabel.setText("Hora: " + horaActual);
            }
        });
    }

    // Método para aplicar un nuevo incremento
    private void aplicarNuevoIncremento() {
        try {
            incremento = Integer.parseInt(incrementoTextField.getText());
        } catch (NumberFormatException e) {
            // Si el valor ingresado no es un número, se reinicia el incremento a 1
            incremento = 1;
            incrementoTextField.setText("1");
        }
        // Reiniciar el contador a cero
        contador = 0;
        contadorLabel.setText("Contador: " + contador);
    }

    // Método principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ContadorReloj::new);
    }
}
