package top.datadriven.dag.model;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @description: 执行节点
 * @author: jiayancheng
 * @email: jiayancheng@foxmail.com
 * @datetime: 2020/5/7 4:25 下午
 * @version: 1.0.0
 */
@Setter
@Getter
public class ExecuteNodeModel extends BaseToString {
    private static final long serialVersionUID = 1663857596203315011L;

    /**
     * 节点code
     */
    private String code;

    /**
     * 当前节点的来源节点
     */
    private List<ExecuteNodeModel> toNodes;

    /**
     * 当前节点的去向节点
     */
    private List<ExecuteNodeModel> fromNodes;

    /**
     * 入度: 初始值为0
     */
    private Integer fromDegree = 0;

    /*==========================辅助函数========================*/

    /**
     * 添加来源node
     */
    public void addFromNode(ExecuteNodeModel node) {
        if (CollectionUtil.isEmpty(fromNodes)) {
            fromNodes = Lists.newArrayList();
        }
        fromNodes.add(node);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
