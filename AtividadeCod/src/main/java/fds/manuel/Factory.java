package fds.manuel;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.List;

public class Factory {

    private static List<Codificador> listadeCodificadores = new ArrayList<>();
    
    static{
        listadeCodificadores.add(new CodificadorCesar());
        listadeCodificadores.add(new CodificadorSimples());
        listadeCodificadores.add(new CodeMorse());
        listadeCodificadores.add(new CodificadorVigenere());

    }  

    /**
     * Função base para devolver o nível do coidificador
     * @param Nivel_desejado_do_parametro
     * @return Melhor_opcap_de_Codificador
     */
    public static String getCodificadores(int nivelDesejado){
        if (listadeCodificadores.isEmpty()) {
            throw new IllegalStateException("Nenhum codificador foi registrado na factory.");
        }

        // 3. Lógica para encontrar o codificador mais próximo.
        Codificador melhorOpcao = null;
        int menorDiferenca = Integer.MAX_VALUE;

        for (Codificador codificador : listadeCodificadores) {
            int diferencaAtual = Math.abs(codificador.getNivelSeguranca() - nivelDesejado);

            // Se a diferença atual for menor, este é o novo melhor candidato.
            if (diferencaAtual < menorDiferenca) {
                menorDiferenca = diferencaAtual;
                melhorOpcao = codificador;
            }
            // Critério de desempate: se a diferença for a mesma, prefere o de maior segurança.
            else if (diferencaAtual == menorDiferenca) {
                if (melhorOpcao != null && codificador.getNivelSeguranca() > melhorOpcao.getNivelSeguranca()) {
                    melhorOpcao = codificador;
                }
            }
        }
        return melhorOpcao.getNome();
    }
}
