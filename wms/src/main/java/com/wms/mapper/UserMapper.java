package com.wms.mapper;

import com.wms.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wsm
 * @since 2023-06-26
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
