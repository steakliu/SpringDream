package org.dream.basic.mapper;

import org.dream.basic.pojo.domain.Post;

public interface PostMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dream_post
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    int deleteByPrimaryKey(Long postId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dream_post
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    int insert(Post record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dream_post
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    int insertSelective(Post record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dream_post
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    Post selectByPrimaryKey(Long postId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dream_post
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    int updateByPrimaryKeySelective(Post record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dream_post
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    int updateByPrimaryKey(Post record);
}