package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author о��
 * @since 2021-05-21
 */

@Data

public class Client {

    /**
     * �ͻ����
     */
    private int c_id;

    /**
     * �ͻ�����
     */
    private String c_name;

    /**
     * �ͻ�����
     */
    private String c_type;

    /**
     * �ͻ���ϵ��ʽ
     */
    private String c_contact;


    public Client(int c_id, String c_name, String c_type, String c_contact) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_type = c_type;
        this.c_contact = c_contact;
    }
}
