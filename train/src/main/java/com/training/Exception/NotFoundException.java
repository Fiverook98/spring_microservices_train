package com.training.Exception;

public class NotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    private String messaggio = "Risorsa Non Trovata";

    public NotFoundException(){super();}

    public NotFoundException(String Messaggio){
        super(Messaggio);
        this.messaggio = Messaggio;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio){
        this.messaggio = messaggio;
    }
}
