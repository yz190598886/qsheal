package com.yz.common;

public class ThisSystemUnit {
    public static String throwIfBlank(String message,String target){
        if(target==null||(target=target.trim()).length()==0){
            throw new ThisSystemException(message);
}
return message;
    }
    public static  String $(String message,String target){
     return throwIfBlank(message, target);
    }
}
