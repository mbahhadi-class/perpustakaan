package id.starter.perustakaan.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author "Noverry Ambo"
 * @start 11/1/2023
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult implements Serializable {
    private Object data;

    private Long rows;

    private String status = StatusCode.OPERATION_SUCCESS;

    public RestResult(Object data) {
        this.data = data;
    }

    public RestResult(Object data, Long rows) {
        this.data = data;
        this.rows = rows;
    }

    public RestResult(Object data,String status) {
        this.data = data;
        this.status = status;
    }

    public RestResult(String status) {
        this.status = status;
    }
}
