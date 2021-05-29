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

public class Freelance {

    /**
     * ����ְҵ�߱��
     */
    private int f_id;

    /**
     * ����ְҵ������
     */
    private String f_name;

    /**
     * ����ְҵ������
     */
    private String f_type;

    /**
     * ����ְҵ����ϵ��ʽ
     */
    private String f_contact;

    public Freelance(int f_id, String f_name, String f_type, String f_contact) {
        this.f_id = f_id;
        this.f_name = f_name;
        this.f_type = f_type;
        this.f_contact = f_contact;
    }
}
