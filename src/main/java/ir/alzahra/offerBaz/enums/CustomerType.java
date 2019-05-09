package ir.alzahra.offerBaz.enums;

/**
 * @Author: Home
 * @Date: 4/19/2019
 **/
public enum CustomerType {

    PERSON ("حقیقی"),
    LEGAL("حقوقی");


    private final String value;

    private CustomerType(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }


}
