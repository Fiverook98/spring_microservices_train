package com.training.Exception;

public class DuplicateException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String messaggio = "Risorsa Duplicata";

    public DuplicateException(){
        super();
    }

    public DuplicateException(String Messaggio){
        super(Messaggio);
        this.messaggio = Messaggio;
    }

    public String getMessaggio(){
        return this.messaggio;
    }

    public void setMessaggio(String Messaggio){
        this.messaggio = Messaggio;
    }
}
