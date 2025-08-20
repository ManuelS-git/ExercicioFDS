package fds.manuel;

public class CodificadorCesar implements Codificador{
    
    @Override
    public String getNome(){
        return "Cifra de Cesar";
    }

    @Override
    public int getNivelSeguranca(){
        return 2;
    }

    @Override
    public String codifica(String str){
        StringBuilder stringCodificador = new StringBuilder();
        for(char charactere : str.toCharArray()){
            if(Character.isLetter(charactere)){
                char base = Character.isLowerCase(charactere) ? 'a' : 'A';
                stringCodificador.append((char) (base + (charactere - base + 3) % 26));
            } else {
                stringCodificador.append(charactere);
            }
        }
        return stringCodificador.toString();
    }

    @Override
    public String decodifica(String textoCodificado) {
        // Para simplificar, a decodificação seria o processo inverso
        // (deslocamento de -3). Não implementado para focar na factory.
        return "Decodificado de Cesar: " + textoCodificado;
    }    
    
}
