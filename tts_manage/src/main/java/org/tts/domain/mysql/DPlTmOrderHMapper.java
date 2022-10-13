package org.tts.domain.mysql;

import org.tts.domain.mysql.entity.DPlTmOrderH;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 天猫订单主表(DPlTmOrderH)表数据库访问层
 *
 * @author Tianjx
 * @since 2022-10-12 14:42:09
 */
public interface DPlTmOrderHMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id ID
     * @return 实例对象
     */
    DPlTmOrderH queryById(Long id);

    /**
     * 通过主键查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    DPlTmOrderH queryByPk( @Param("tid") Long tid);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DPlTmOrderH> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dPlTmOrderH 实例对象
     * @return 对象列表
     */
    List<DPlTmOrderH> queryAll(DPlTmOrderH dPlTmOrderH);

    /**
     * 新增数据
     *
     * @param dPlTmOrderH 实例对象
     * @return 影响行数
     */
    int insert(DPlTmOrderH dPlTmOrderH);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DPlTmOrderH> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DPlTmOrderH> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DPlTmOrderH> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<DPlTmOrderH> entities);

    /**
     * 通过ID修改数据
     *
     * @param dPlTmOrderH 实例对象
     * @return 影响行数
     */
    int updateById(DPlTmOrderH dPlTmOrderH);

    /**
     * 通过主键修改数据
     *
     * @param dPlTmOrderH 实例对象
     * @return 影响行数
     */
    int updateByPk(DPlTmOrderH dPlTmOrderH);

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
             * @return 影响行数
     */
    int deleteByPk( @Param("tid") Long tid);
}