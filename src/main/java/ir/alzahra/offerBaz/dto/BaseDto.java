package ir.alzahra.offerBaz.dto;

import ir.alzahra.offerBaz.enums.DtoState;

/**
 * @author z.moafi
 * @since 13/08/2019
 */
public class BaseDto {


    private Long version;

    private DtoState dtoState = DtoState.None;


    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public DtoState getDtoState() {
        return dtoState;
    }

    public void setDtoState(DtoState dtoState) {
        this.dtoState = dtoState;
    }
}
