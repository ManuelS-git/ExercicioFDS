package fds.manuel;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Codificador morse = new CodeMorse();
        Codificador vigen = new CodificadorVigenere();
        Factory fab = new Factory();
        Scanner teclado = new Scanner(System.in);
        //System.out.println("Versao: "+cod.getDataCriacao());
        System.out.println("Digite o nivel de segurança desejado)");
        int nivel = teclado.nextInt();
        System.out.println("Melhor Nivel de segurança: "+ fab.getCodificadores(nivel));
        
        System.out.println("////////////////////////////////////");

        System.out.println("Exemplo com o código morse");
        String texto = "Este e o string a ser codificado";
        String codificado = morse.codifica(texto);
        String decodificado = morse.decodifica(codificado);
        System.out.println("Texto original: "+texto);
        System.out.println("Texto codificado: "+ codificado);
        System.out.println("Texto decodificado: "+decodificado);

        System.out.println("////////////////////////////////////");

        System.out.println("Exemplo com o código Vigenere");
        codificado = vigen.codifica(texto);
        decodificado = vigen.decodifica(codificado);
        System.out.println("Texto original: "+texto);
        System.out.println("Texto codificado: "+codificado);
        System.out.println("Texto decodificado: "+decodificado);
        
    }
}