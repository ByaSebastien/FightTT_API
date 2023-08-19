package be.paquya.fighttt_api.exceptions;

public class FightTTException extends RuntimeException{

    public FightTTException(){
        super("Error");
    }

    public FightTTException(String message){
        super(message);
    }
}
