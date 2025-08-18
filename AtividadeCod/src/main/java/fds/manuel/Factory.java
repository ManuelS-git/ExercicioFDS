package fds.manuel;
import java.util.ArrayList;
import java.util.List;

public class Factory {
    private static List<Codificador> listadeCodificadores = new ArrayList<>();
    //static(
        //listadeCodificadores.add(new CodificadorMorse);
        //listadeCodificadores.add(new CodificadorVigenere);
    //    )

    private static Codificador getCodificadores(int nivelDesejado){
        if(listadeCodificadores.isEmpty()){
            throw new IllegalStateException("Nenhum Codificador registrad");
        }

        Codificador melhorOp = null;
        int menorDiferenca = Integer.MAX_VALUE;

        for(Codificador codifica : listadeCodificadores){
            int diferencaAtual = Math.abs(codifica.getNivelSeguranca() - nivelDesejado);

            if(diferencaAtual < menorDiferenca){
                menorDiferenca = diferencaAtual;
                melhorOp = codifica;
            }
            else if(diferencaAtual == menorDiferenca){
                if(melhorOp != null && codifica.getNivelSeguranca() > melhorOp.getNivelSeguranca()){
                    melhorOp = codifica;
                }
            }
        }

        return melhorOp;

    }
}
