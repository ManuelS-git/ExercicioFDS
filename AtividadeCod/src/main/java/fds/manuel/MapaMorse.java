package fds.manuel;

import java.util.Map;

public class MapaMorse {
    public static final Map<Character,String> MORSE = Map.ofEntries(
        Map.entry('A', ".-"), 
        Map.entry('B', "-..."), 
        Map.entry('C', "-.-."),
        Map.entry('D', "-.."), 
        Map.entry('E', "."), 
        Map.entry('F', "..-."),
        Map.entry('G', "--."), 
        Map.entry('H', "...."), 
        Map.entry('I', ".."),
        Map.entry('J', ".---"), 
        Map.entry('K', "-.-"), 
        Map.entry('L', ".-.."),
        Map.entry('M', "--"), 
        Map.entry('N', "-."), 
        Map.entry('O', "---"),
        Map.entry('P', ".--."), 
        Map.entry('Q', "--.-"), 
        Map.entry('R', ".-."),
        Map.entry('S', "..."), 
        Map.entry('T', "-"), 
        Map.entry('U', "..-"),
        Map.entry('V', "...-"), 
        Map.entry('W', ".--"), 
        Map.entry('X', "-..-"),
        Map.entry('Y', "-.--"), 
        Map.entry('Z', "--.."),
        Map.entry(' ', "/")
);
public static Character getChavePorMorse(String morse) {
    for (Map.Entry<Character, String> entry : MORSE.entrySet()) {
        if (entry.getValue().equals(morse)) {
            return entry.getKey();
        }
    }
    return null; // Não encontrado
}
}
    
