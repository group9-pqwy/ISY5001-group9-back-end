package nus.iss.ais.carquest.mapper;

import java.util.List;
import nus.iss.ais.carquest.model.Users;
import nus.iss.ais.carquest.model.UsersExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UsersMapper {
    long countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(Users row);

    int insertSelective(Users row);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("row") Users row, @Param("example") UsersExample example);

    int updateByExample(@Param("row") Users row, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users row);

    int updateByPrimaryKey(Users row);
}