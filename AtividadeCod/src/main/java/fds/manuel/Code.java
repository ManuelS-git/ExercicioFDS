package fds.manuel;

public class Code {
    
    private String text;
    
    public Code(String text){
        this.text = text;
    }
    public void codify(){
        String aux = "";
        for(char c: text.toUpperCase().toCharArray()){
            aux = aux + MapaMorse.MORSE.get(c) + " ";
        }
        this.text = aux;
    }
    public void decodify(){
        String aux = "";
        String auxx[] = text.split(" ");
        for(String letra: auxx){
            if(MapaMorse.getChavePorMorse(letra) != null){
                char c = MapaMorse.getChavePorMorse(letra);
                aux = aux + c;
            }
        }
        this.text = aux;

    }
    public String toString(){
        return text;
    }
    public static void main(String[] args) {
        Code codigo = new Code("Hello World");
        System.out.println(codigo);
        codigo.codify();
        System.out.println(codigo);
        codigo.decodify();
        System.out.println(codigo);
    }
}
