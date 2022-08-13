package com.newland.mybatis.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName(value = "t_user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "username" ) //必须添加
    private String name;

    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    @TableField(value = "is_deleted")
    private Boolean deleted;  //0 false 未删除;   1 true 已删除
}
