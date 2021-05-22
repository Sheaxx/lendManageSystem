package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author 芯悦
 * @since 2021-05-21
 */

@Data

public class Client {

    /**
     * 客户编号
     */
    private int c_id;

    /**
     * 客户姓名
     */
    private String c_name;

    /**
     * 客户类型
     */
    private String c_type;

    /**
     * 客户联系方式
     */
    private String c_contact;


    public Client(int c_id, String c_name, String c_type, String c_contact) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_type = c_type;
        this.c_contact = c_contact;
    }
}
