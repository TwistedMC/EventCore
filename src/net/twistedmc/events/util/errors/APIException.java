package net.twistedmc.events.util.errors;


public class APIException extends java.lang.Exception {

       public APIException(String str) {
           super("[API] {Exception} : " + str);
       } 
    
}
