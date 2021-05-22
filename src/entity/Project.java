package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </p>
 *
 * @author о��
 * @since 2021-05-21
 */

@Data
@NoArgsConstructor
public class Project {

    /**
     * ��Ŀ���
     */
    private int p_id;

    /**
     * ��Ŀ����
     */
    private String p_name;

    /**
     * ��Ŀ����
     */
    private String p_type;

    /**
     * ��Ŀ����
     */
    private String p_content;

    public Project(int p_id, String p_name, String p_type, String p_content) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_type = p_type;
        this.p_content = p_content;
    }
}
