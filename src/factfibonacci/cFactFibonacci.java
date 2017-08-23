/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factfibonacci;

//Librerías
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Aguilar Baez Javier Alejandro y Genaro Enrique Martínez Barbosa, 5IM6
 * @version  1.0 
 * created on 2017/08/18
 */
public class cFactFibonacci extends JFrame implements ActionListener{ //Esta clase contiene toda la ventana
    private JFrame _ventana;    
    private JTextField _numeroTxt, _resultadoTxt;
    private JButton _factorialBtn, _fibonacciBtn, _borrar, _salir;
    private JLabel _titulo, _subtitulo, _aviso;    
    private Container _contenedor;
    
    public cFactFibonacci () //Método Constructor
    {
        configVentana();
        muestraComponentes();
        this._ventana.setVisible(true);
    }
    
    public void configVentana() //Se configuran todas las características de la ventana
    {
        _ventana = new JFrame();
        _ventana.setSize(800, 650);
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _ventana.setLocationRelativeTo(null); 
        _ventana.setLayout(null);
        _ventana.setResizable(false);        
        _contenedor = _ventana.getContentPane();  
        _contenedor.setBackground(Color.BLUE);
    }
    
    public void muestraComponentes() //Se configuran todas las características de los elementos la ventana
    {
        _factorialBtn = new JButton("Factorial"); //Botón con el que se obtiene el factorial de un número entero
        _factorialBtn.setBounds(100, 280, 250, 100);  
        _factorialBtn.setBackground(Color.GREEN);
        _factorialBtn.setForeground(Color.RED);
        _factorialBtn.setFont(new Font("Tahoma", 1, 20));
        _contenedor.add(_factorialBtn);
        _factorialBtn.addActionListener(this);
        _factorialBtn.setVisible(true);        
        
        _fibonacciBtn = new JButton("Fibonacci"); //Botón con el que se obtiene la serie de Fibonacci hasta la posición indicada
        _fibonacciBtn.setBounds(450, 280, 250, 100);  
        _fibonacciBtn.setBackground(Color.RED);
        _fibonacciBtn.setForeground(Color.GREEN);
        _fibonacciBtn.setFont(new Font("Tahoma", 1, 20));
        _contenedor.add(_fibonacciBtn);
        _fibonacciBtn.addActionListener(this);
        _fibonacciBtn.setVisible(true);
        
        _borrar = new JButton("Borrar"); //Borra los campos de texto
        _borrar.setBounds(570, 410, 120, 60);  
        _borrar.setBackground(Color.ORANGE);
        _borrar.setForeground(Color.RED);
        _borrar.setFont(new Font("Calibri", 1, 20));
        _contenedor.add(_borrar);
        _borrar.addActionListener(this);
        _borrar.setVisible(true);
        
        _salir = new JButton("Salir"); //Salir del programa
        _salir.setBounds(600, 530, 150, 60);  
        _salir.setBackground(Color.CYAN);
        _salir.setForeground(Color.BLACK);
        _salir.setFont(new Font("Calibri", 1, 20));
        _contenedor.add(_salir);
        _salir.addActionListener(this);
        _salir.setVisible(true);
        
        _numeroTxt = new JTextField(); //Caja de texto para ingresar el número
        _numeroTxt.setBounds(100, 180, 400, 30);
        _contenedor.add(_numeroTxt);
        _numeroTxt.setVisible(true);
        
        _resultadoTxt = new JTextField(); //Caja de texto para desplegar el resultado
        _resultadoTxt.setBounds(100, 430, 400, 30);
        _contenedor.add(_resultadoTxt);
        _resultadoTxt.setVisible(true);
        _resultadoTxt.setEditable(false);
        
        _titulo = new JLabel("Obtener Factorial o Fibonacci"); //El título
        _titulo.setBounds(150, 50, 700, 50);
        _titulo.setFont(new Font("Times New Roman", 1, 40));
        _titulo.setForeground(Color.RED);
        _contenedor.add(_titulo);
        _titulo.setVisible(true);
        
        _subtitulo = new JLabel("Ingrese un número y elija el botón de su preferencia."); //Instrucciones
        _subtitulo.setBounds(100, 100, 500, 50);
        _subtitulo.setFont(new Font("Verdana", 1, 16));
        _subtitulo.setForeground(Color.YELLOW);
        _contenedor.add(_subtitulo);
        _subtitulo.setVisible(true);
        
        _aviso = new JLabel("*Nota: Sólo puede ingresar números enteros. De lo contrario, el programa no funcionará."); //Un pequeño aviso
        _aviso.setBounds(100, 480, 600, 50);
        _aviso.setFont(new Font("Century Gothic", 1, 12));
        _aviso.setForeground(Color.WHITE);
        _contenedor.add(_aviso);
        _aviso.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == _factorialBtn) //Si el botón oprimido es el de Factorial
        {
            if (!_numeroTxt.getText().isEmpty()) //Valida que el campo de texto no esté vacío
            {
                try
                {
                    String cadFactorial = _numeroTxt.getText(); //Toma el texto
                    boolean bienFact = true; //Variable booleana para validar que los datos sean correctos
                    for (int i = 0; i<cadFactorial.length(); i++) //Iteración para validar que cada caracter es un dígito
                    {
                        if (cadFactorial.charAt(i) != '0' && cadFactorial.charAt(i) != '1' & cadFactorial.charAt(i) != '2' & cadFactorial.charAt(i) != '3' & cadFactorial.charAt(i) != '4' & cadFactorial.charAt(i) != '5' & cadFactorial.charAt(i) != '6' & cadFactorial.charAt(i) != '7' & cadFactorial.charAt(i) != '8' & cadFactorial.charAt(i) != '9')
                        {
                            bienFact = false; //Si no es un número, el booleano se hace falso
                        } 
                    }
                    if (bienFact = true) //Continúa el proceso si se valida que es un número
                    {
                        int numero = Integer.parseInt(cadFactorial); //Convierte a entero la cadena
                        int resultado = 1; //Valor default del resultado (siempre multiplicará por uno)
                        for (int xNumero = numero; xNumero > 0; xNumero--) //Multiplica todos los números, desde ese número hasta uno
                        {
                            resultado *= xNumero;
                        }
                        _resultadoTxt.setText(String.valueOf(resultado)); //Despliega el resultado
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Sólo puedes ingresar números enteros.");
                        _numeroTxt.setText(null);
                    }
                }
                catch (Exception exc)
                {
                    JOptionPane.showMessageDialog(this, "Sólo puedes ingresar números enteros.");
                    _numeroTxt.setText(null);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Ingresa un número.");
            }
        }
        else
        {
            if (e.getSource() == _fibonacciBtn) //Si el botón oprimido es el de Fibonacci
            {
                if (!_numeroTxt.getText().isEmpty()) //Valida que el campo de texto no esté vacío
                {
                    try
                    {
                        String cadFibonacci = _numeroTxt.getText(); //Toma el texto
                        boolean bienFibonacci = true; //Variable booleana para validar que los datos sean correctos
                        for (int i = 0; i<cadFibonacci.length(); i++) //Iteración para validar que cada caracter es un dígito
                        {
                            if (cadFibonacci.charAt(i) != '0' && cadFibonacci.charAt(i) != '1' & cadFibonacci.charAt(i) != '2' & cadFibonacci.charAt(i) != '3' & cadFibonacci.charAt(i) != '4' & cadFibonacci.charAt(i) != '5' & cadFibonacci.charAt(i) != '6' & cadFibonacci.charAt(i) != '7' & cadFibonacci.charAt(i) != '8' & cadFibonacci.charAt(i) != '9')
                            {
                                bienFibonacci = false; //Si no es un número, el booleano se hace falso
                            } 
                        }
                        if (bienFibonacci = true) //Continúa el proceso si se valida que es un número
                        {
                            int posicion = Integer.parseInt(cadFibonacci); //Lo convierte a entero
                            int num1 = 0; //Número 1 de la suma
                            int num2 = 1; //Número 2 de la suma
                            int resultado = 0; //Resultado de la suma
                            String texto = "";
                            if (posicion == 0)
                            {
                                JOptionPane.showMessageDialog(this, "No hay posición cero.");
                                _numeroTxt.setText(null);
                            }
                            else
                            {
                                if (posicion == 1)
                                {
                                    texto = "0";
                                }
                                else
                                {
                                    texto = "0-1";
                                    for (int xNumero = 0; xNumero < posicion-2; xNumero++) //Va sumando los valores, y recorriendo los números de la suma
                                    {                                                                    
                                        resultado = num1 + num2;
                                        num1 = num2;
                                        num2 = resultado;         
                                        texto += "-" + String.valueOf(resultado); //Agrega guiones a la serie para distinguir números de dos dígitos
                                    }
                                }
                            }                            
                            _resultadoTxt.setText(texto); //Despliega el resultado
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(this, "Sólo puedes ingresar números enteros.");
                            _numeroTxt.setText(null);
                        }
                    }
                    catch (Exception exc)
                    {
                        JOptionPane.showMessageDialog(this, "Sólo puedes ingresar números enteros.");
                        _numeroTxt.setText(null);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Ingresa un número.");
                }
            }
            else
            {
                if (e.getSource() == _borrar)
                {
                    if (!_numeroTxt.getText().isEmpty() || !_resultadoTxt.getText().isEmpty()) //Borra lo escrito, sólo si hay algo escrito
                    {
                        _numeroTxt.setText(null);
                        _resultadoTxt.setText(null);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "¿¡Qué quieres borrar!?");
                    }
                } 
                else
                {
                    if (e.getSource() == _salir)
                    {
                        JOptionPane.showMessageDialog(this, "¡Gracias por usar este programa!");
                        System.exit(0);
                    }
                }
            }
        }
    }
}
