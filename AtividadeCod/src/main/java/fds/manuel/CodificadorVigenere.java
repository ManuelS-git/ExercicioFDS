package fds.manuel;

import java.time.LocalDate;

/**
 * Implementação da cifra de Vigenère
 * Essa implementacao ignora, mantendo caracteres nao alfabeticos 
 * Preserva o Case da letra
 * 
 * Ref para construcao
 * https://cifradevigenere.vercel.app/artigo#oque-e-a-cifra-de-vigenere
 * 
 * 
 * Link para API do StringBuilder
 * https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
 * 
 * 
 * @author Bryan Melo
 * @version 1
 */
public class CodificadorVigenere implements Codificador {

    //Chave para criptografar e descriptografar
    private final String chave;

    /**
     * @param chave chave para a criacao da codificacao e da decodificacao.
     **/
    public CodificadorVigenere(String chave) {
        this.chave = chave.toUpperCase();
    }

    @Override
    public String getNome() {
        return "Codificador Vigenere";
    }

    @Override
    public LocalDate getDataCriacao() {
        return LocalDate.of(2025, 8, 18);
    }

    @Override
    public int getNivelSeguranca() {
        // Alterem conforme o nivel da outra
        return 3;
    }

    //Metodos para co e decodificacao em si

    /**
     * Letras são cifradas usando deslocamentos determinados pela chave, seguindo a formula:
     * C = P + K (mod 26)
     * numeros e outros carac serao apenas ignorados
     * Mantem o Case da letra
     * @param str texto para ser modificado
     * @return String "criptografada".
     */
    @Override
    public String codifica(String str) {
        //Trabalhar com a classe de Strings
        StringBuilder sb = new StringBuilder();
        int j = 0;

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {

                //se for alfabetico, passa por aqui
                char UpperLower = Character.isUpperCase(c) ? 'A' : 'a';
                int shift = chave.charAt(j % chave.length()) - 'A';
                sb.append((char) ((c - UpperLower + shift) % 26 + UpperLower));
                j++;
            } else {
                //caso nao, nao sera codificado
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Decodifica a string.
     * Mantem o Case da letra
     * @param str String a ser decodificada.
     * @return String decodificada.
     */
    @Override
    public String decodifica(String str) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {

                //caso alfabetico
                char UpperLower = Character.isUpperCase(c) ? 'A' : 'a';
                int shift = chave.charAt(j % chave.length()) - 'A';
                sb.append((char) ((c - UpperLower - shift + 26) % 26 + UpperLower));
                j++;
            } else {

                //caso nao
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
