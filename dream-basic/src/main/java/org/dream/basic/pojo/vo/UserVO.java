package org.dream.basic.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class UserVO {
    private Long userId;

    private Long deptId;

    private String deptName;

    private String userName;

    private String nickName;

    private String email;

    private String phone;

    private String sex;

    private String status;

    private String createBy;

    private Date createTime;

    private List<String> roleNameList;

    private List<Long> roleIdList;
}
