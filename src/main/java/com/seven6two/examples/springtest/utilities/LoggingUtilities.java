package com.seven6two.examples.springtest.utilities;

public class LoggingUtilities {

    private final CommonUtilities commonUtils = CommonUtilities.getInstance();

    public String message(String input){
        String Template = ("[ MESSAGE ] - " + commonUtils.getDateTime() + " - s%");
        return String.format(Template, input);
    }


}
