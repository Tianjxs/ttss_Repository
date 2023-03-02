package org.tts.domain.mysql;

import org.tts.domain.mysql.entity.DHemsInOrderStatus17H;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 拉取Hems订单状态信息表(DHemsInOrderStatus17H)表数据库访问层
 *
 * @author Tianjx
 * @since 2023-03-01 11:18:54
 */
public interface DHemsInOrderStatus17HMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id ID
     * @return 实例对象
     */
    DHemsInOrderStatus17H queryById(Long id);

    /**
     * 通过主键查询单条数据
     *
     * @param orderId 主键
     * @param stautsOflineHems 主键
     * @return 实例对象
     */
    DHemsInOrderStatus17H queryByPk( @Param("orderId") String orderId,  @Param("stautsOflineHems") Integer stautsOflineHems);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DHemsInOrderStatus17H> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dHemsInOrderStatus17H 实例对象
     * @return 对象列表
     */
    List<DHemsInOrderStatus17H> queryAll(DHemsInOrderStatus17H dHemsInOrderStatus17H);

    /**
     * 新增数据
     *
     * @param dHemsInOrderStatus17H 实例对象
     * @return 影响行数
     */
    int insert(DHemsInOrderStatus17H dHemsInOrderStatus17H);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DHemsInOrderStatus17H> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DHemsInOrderStatus17H> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DHemsInOrderStatus17H> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<DHemsInOrderStatus17H> entities);

    /**
     * 通过ID修改数据
     *
     * @param dHemsInOrderStatus17H 实例对象
     * @return 影响行数
     */
    int updateById(DHemsInOrderStatus17H dHemsInOrderStatus17H);

    /**
     * 通过主键修改数据
     *
     * @param dHemsInOrderStatus17H 实例对象
     * @return 影响行数
     */
    int updateByPk(DHemsInOrderStatus17H dHemsInOrderStatus17H);

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
             * @param stautsOflineHems 主键
             * @return 影响行数
     */
    int deleteByPk( @Param("orderId") String orderId,  @Param("stautsOflineHems") Integer stautsOflineHems);
}