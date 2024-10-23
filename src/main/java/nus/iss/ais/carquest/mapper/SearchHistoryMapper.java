package nus.iss.ais.carquest.mapper;

import java.util.List;
import nus.iss.ais.carquest.model.SearchHistory;
import nus.iss.ais.carquest.model.SearchHistoryExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SearchHistoryMapper {
    long countByExample(SearchHistoryExample example);

    int deleteByExample(SearchHistoryExample example);

    int deleteByPrimaryKey(Integer searchId);

    int insert(SearchHistory row);

    int insertSelective(SearchHistory row);

    List<SearchHistory> selectByExample(SearchHistoryExample example);

    SearchHistory selectByPrimaryKey(Integer searchId);

    int updateByExampleSelective(@Param("row") SearchHistory row, @Param("example") SearchHistoryExample example);

    int updateByExample(@Param("row") SearchHistory row, @Param("example") SearchHistoryExample example);

    int updateByPrimaryKeySelective(SearchHistory row);

    int updateByPrimaryKey(SearchHistory row);

    List<SearchHistory> selectMostFrequentSearch(@Param("userId") Integer userId);
}