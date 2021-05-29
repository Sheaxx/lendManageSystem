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
public class Project {

    /**
     * 项目编号
     */
    private int p_id;

    /**
     * 项目名称
     */
    private String p_name;

    /**
     * 项目类型
     */
    private String p_type;

    /**
     * 项目内容
     */
    private String p_content;

    public Project(int p_id, String p_name, String p_type, String p_content) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_type = p_type;
        this.p_content = p_content;
    }
}
