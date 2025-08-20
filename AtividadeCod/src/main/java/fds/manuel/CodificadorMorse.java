package fds.manuel;

public class CodificadorMorse implements Codificador{
    
    // A classe não precisa mais de variáveis de estado (como 'private String text')
    // nem de um construtor que receba o texto.

    @Override
    public String getNome() {
        return "Codificador Morse";
    }

    /**
     * O Código Morse é para transmissão, não segurança. Por isso, nível 1.
     */
    @Override
    public int getNivelSeguranca() {
        return 1;
    }

    /**
     * Este método agora recebe um texto (str), o processa e retorna o resultado
     * codificado, como definido na interface.
     */
    @Override
    public String codifica(String str) {
        if (str == null) {
            return "";
        }
        
        StringBuilder resultado = new StringBuilder();
        // Itera sobre o texto recebido no parâmetro 'str'
        for (char caractere : str.toUpperCase().toCharArray()) {
            String morseChar = MapaMorse.MORSE.get(caractere);
            if (morseChar != null) {
                resultado.append(morseChar).append(" ");
            }
        }
        // Retorna a string construída, removendo o espaço extra no final
        return resultado.toString().trim();
    }

    /**
     * Este método agora recebe um texto codificado (str), o processa e retorna
     * o texto original, como definido na interface.
     */
    @Override
    public String decodifica(String str) {
        if (str == null) {
            return "";
        }

        StringBuilder resultado = new StringBuilder();
        // Divide a string recebida no parâmetro 'str'
        String[] letrasMorse = str.split(" ");
        
        for (String morse : letrasMorse) {
            Character caractere = MapaMorse.getChavePorMorse(morse);
            if (caractere != null) {
                resultado.append(caractere);
            }
        }
        return resultado.toString();
    }
}
