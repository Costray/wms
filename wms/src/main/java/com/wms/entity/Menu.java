package com.wms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wsm
 * @since 2023-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 菜单编码
     */
    @TableField("menuCode")
    private String menucode;

    /**
     * 菜单名字
     */
    @TableField("menuName")
    private String menuname;

    /**
     * 菜单级别
     */
    @TableField("menuLevel")
    private String menulevel;

    /**
     * 菜单的父code
     */
    @TableField("menuParentCode")
    private String menuparentcode;

    /**
     * 菜单点击触发的函数
     */
    @TableField("menuClick")
    private String menuclick;

    /**
     * 权限0超级管理员,1管理员,2普通用户
     */
    @TableField("menuRight")
    private String menuright;

    @TableField("menuComponent")
    private String menucomponent;

    @TableField("menuIcon")
    private String menuicon;


}
