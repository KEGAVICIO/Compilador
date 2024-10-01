package codigo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class thisXD extends JFrame{
    private JTextArea txtCode;
    private JButton analizador;
    private JTextArea txtAnalizado;
    private JPanel START;

    public thisXD() {
        setContentPane(START);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        analizador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File archivo = new File("codigots.txt");
                PrintWriter escribir;
                try {
                    escribir = new PrintWriter(archivo);
                    escribir.print(txtCode.getText());
                    escribir.close();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    Reader leer = new BufferedReader(new FileReader("codigots.txt"));
                    Lexer lexer = new Lexer(leer);
                    String res="";
                    while(true){
                        tokens tokens = lexer.yylex();
                        if(tokens == null){
                            res += "\nFIN ARCHIVO";
                            txtAnalizado.setText(res);
                            return;
                        }
                        switch (tokens){
                            case ERROR:
                                res += "ERROR NMMS\n";
                                break;
                            case Numero, Igual, Suma, Reservadas:
                                res += lexer.lexeme+": Es un "+tokens+"\n";
                                break;
                            default: throw new AssertionError();
                        }
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public static void main(String[] args){
        new thisXD();
    }
}
