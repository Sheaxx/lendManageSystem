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

public class Freelance {

    /**
     * 自由职业者编号
     */
    private int f_id;

    /**
     * 自由职业者姓名
     */
    private String f_name;

    /**
     * 自由职业者类型
     */
    private String f_type;

    /**
     * 自由职业者联系方式
     */
    private String f_contact;

    public Freelance(int f_id, String f_name, String f_type, String f_contact) {
        this.f_id = f_id;
        this.f_name = f_name;
        this.f_type = f_type;
        this.f_contact = f_contact;
    }
}
