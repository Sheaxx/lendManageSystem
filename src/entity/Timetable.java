package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </p>
 *
 * @author 芯悦
 * @since 2021-05-21
 */

@Data
@NoArgsConstructor
public class Timetable {

    /**
     * 时间表编号
     */
    private int t_id;

    /**
     * 时间表对应的自由职业者编号
     */
    private String t_fid;

    /**
     * 时间表内容
     */
    private String t_content;

    public Timetable(int t_id, String t_fid, String t_content) {
        this.t_id = t_id;
        this.t_fid = t_fid;
        this.t_content = t_content;
    }
}
