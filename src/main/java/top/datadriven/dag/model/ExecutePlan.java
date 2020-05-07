package top.datadriven.dag.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @description: 执行计划
 * @author: jiayancheng
 * @email: jiayancheng@foxmail.com
 * @datetime: 2020/5/7 4:19 下午
 * @version: 1.0.0
 */
@Setter
@Getter
public class ExecutePlan extends BaseToString {
    private static final long serialVersionUID = -3708177223244282958L;

    /**
     * 根节点
     */
    private ExecuteNodeModel rootNode;
}
