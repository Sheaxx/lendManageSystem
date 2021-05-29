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
public class Timetable {

    /**
     * ʱ�����
     */
    private int t_id;

    /**
     * ʱ����Ӧ������ְҵ�߱��
     */
    private String t_fid;

    /**
     * ʱ�������
     */
    private String t_content;

    public Timetable(int t_id, String t_fid, String t_content) {
        this.t_id = t_id;
        this.t_fid = t_fid;
        this.t_content = t_content;
    }
}
