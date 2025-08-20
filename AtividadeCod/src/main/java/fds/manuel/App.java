package fds.manuel;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Codificador cod = new CodificadorSimples();
        Factory fab = new Factory();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Codificador: "+cod.getNome());
        //System.out.println("Versao: "+cod.getDataCriacao());
        System.out.println("Digite o nivel de segurança desejado)");
        int nivel = teclado.nextInt();
        System.out.println("Melhor Nivel de segurança: "+ fab.getCodificadores(nivel));
        
        String texto = "Este e o string a ser codificado";
        String codificado = cod.codifica(texto);
        String decodificado = cod.decodifica(codificado);

        System.out.println("Texto original: "+texto);
        System.out.println("Texto codificado: "+codificado);
        System.out.println("Texto decodificado: "+decodificado);
    }
}
