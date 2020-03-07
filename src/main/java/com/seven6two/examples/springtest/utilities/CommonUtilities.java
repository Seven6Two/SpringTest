package com.seven6two.examples.springtest.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtilities {

    private static CommonUtilities instance = null;

    private CommonUtilities() {}

    public static CommonUtilities getInstance(){
        if (instance == null) {
            instance = new CommonUtilities();
        }
        return instance;
    }

    private final String DATE_TIME = "dd/MM/yyyy @ hh:mm:ss";
    public String getDateTime(){
        return getDateTime(DATE_TIME);
    }
    public String getDateTime(String format){
        return new SimpleDateFormat(format).format(new Date());
    }

}
