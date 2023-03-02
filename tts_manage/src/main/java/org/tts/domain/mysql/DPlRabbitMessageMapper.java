package org.tts.domain.mysql;

import org.tts.domain.mysql.entity.DPlRabbitMessage;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (DPlRabbitMessage)表数据库访问层
 *
 * @author Tianjx
 * @since 2023-03-01 13:36:38
 */
public interface DPlRabbitMessageMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id ID
     * @return 实例对象
     */
    DPlRabbitMessage queryById(Long id);

    /**
     * 通过主键查询单条数据
     *
     * @param orderId 主键
     * @param type 主键
     * @return 实例对象
     */
    DPlRabbitMessage queryByPk( @Param("orderId") String orderId,  @Param("type") Integer type);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DPlRabbitMessage> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dPlRabbitMessage 实例对象
     * @return 对象列表
     */
    List<DPlRabbitMessage> queryAll(DPlRabbitMessage dPlRabbitMessage);

    /**
     * 新增数据
     *
     * @param dPlRabbitMessage 实例对象
     * @return 影响行数
     */
    int insert(DPlRabbitMessage dPlRabbitMessage);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DPlRabbitMessage> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DPlRabbitMessage> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DPlRabbitMessage> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<DPlRabbitMessage> entities);

    /**
     * 通过ID修改数据
     *
     * @param dPlRabbitMessage 实例对象
     * @return 影响行数
     */
    int updateById(DPlRabbitMessage dPlRabbitMessage);

    /**
     * 通过主键修改数据
     *
     * @param dPlRabbitMessage 实例对象
     * @return 影响行数
     */
    int updateByPk(DPlRabbitMessage dPlRabbitMessage);

    /**
     * 通过ID删除数据
     *
     * @param id ID
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 通过主键删除数据
     *
             * @param orderId 主键
             * @param type 主键
             * @return 影响行数
     */
    int deleteByPk( @Param("orderId") String orderId,  @Param("type") Integer type);
}