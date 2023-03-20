package org.tts.domain.mysql;

import org.tts.domain.mysql.entity.DPlTmOrderOrdersD;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 天猫订单明细订单列表(DPlTmOrderOrdersD)表数据库访问层
 *
 * @author Tianjx
 * @since 2023-03-17 15:13:51
 */
public interface DPlTmOrderOrdersDMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id ID
     * @return 实例对象
     */
    DPlTmOrderOrdersD queryById(Long id);

    /**
     * 通过主键查询单条数据
     *
     * @param tid 主键
     * @param oid 主键
     * @return 实例对象
     */
    DPlTmOrderOrdersD queryByPk( @Param("tid") Long tid,  @Param("oid") String oid);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DPlTmOrderOrdersD> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dPlTmOrderOrdersD 实例对象
     * @return 对象列表
     */
    List<DPlTmOrderOrdersD> queryAll(DPlTmOrderOrdersD dPlTmOrderOrdersD);

    /**
     * 新增数据
     *
     * @param dPlTmOrderOrdersD 实例对象
     * @return 影响行数
     */
    int insert(DPlTmOrderOrdersD dPlTmOrderOrdersD);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DPlTmOrderOrdersD> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DPlTmOrderOrdersD> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DPlTmOrderOrdersD> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<DPlTmOrderOrdersD> entities);

    /**
     * 通过ID修改数据
     *
     * @param dPlTmOrderOrdersD 实例对象
     * @return 影响行数
     */
    int updateById(DPlTmOrderOrdersD dPlTmOrderOrdersD);

    /**
     * 通过主键修改数据
     *
     * @param dPlTmOrderOrdersD 实例对象
     * @return 影响行数
     */
    int updateByPk(DPlTmOrderOrdersD dPlTmOrderOrdersD);

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
             * @param tid 主键
             * @param oid 主键
             * @return 影响行数
     */
    int deleteByPk( @Param("tid") Long tid,  @Param("oid") String oid);
}