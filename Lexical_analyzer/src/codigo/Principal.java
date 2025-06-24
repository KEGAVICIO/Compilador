package codigo;

import jflex.exceptions.SilentExit;

public class Principal {
    public static void main(String[] args) throws SilentExit {
        String[] ruta ={"C:/Users/rines/IdeaProjects/AnalizadorLexico/src/codigo/lexer.flex"};
        generarLexer(ruta);
    }
    public static void generarLexer(String[] ruta) throws SilentExit {
        jflex.Main.generate(ruta);
    }
}
