package com.hd.dao;

import java.util.List;

import com.hd.common.BaseConditionVO;
import com.hd.model.Userbean;

public interface UserbeanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CAR.T_USER
     *
     * @mbggenerated Mon Mar 13 16:44:13 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CAR.T_USER
     *
     * @mbggenerated Mon Mar 13 16:44:13 CST 2017
     */
    int insert(Userbean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CAR.T_USER
     *
     * @mbggenerated Mon Mar 13 16:44:13 CST 2017
     */
    int insertSelective(Userbean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CAR.T_USER
     *
     * @mbggenerated Mon Mar 13 16:44:13 CST 2017
     */
    Userbean selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CAR.T_USER
     *
     * @mbggenerated Mon Mar 13 16:44:13 CST 2017
     */
    int updateByPrimaryKeySelective(Userbean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CAR.T_USER
     *
     * @mbggenerated Mon Mar 13 16:44:13 CST 2017
     */
    int updateByPrimaryKey(Userbean record);
    /**
     * 查询所有  这个可以不要了
     * @return
     */
    List<Userbean> queryAll();
    /**
     * 根据条件查询
     * @param vo
     * @return
     */
    List<Userbean> query(BaseConditionVO vo);
}