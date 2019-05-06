package ir.alzahra.offerBaz.enums;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/18/2019, Thu
 **/
public enum Gender {
        FEMALE("زن"),
        MALE("مرد");

      /*  private int code;
        Gender(int i) {
            code = i;
        }*/
      private final String value;

        private Gender(String value) {
                this.value = value;
        }

        public String getValue(){
                return value;
        }


}
