package top.datadriven.dag.util;

import cn.hutool.core.collection.CollectionUtil;
import top.datadriven.dag.model.ExecuteNodeModel;

import java.util.List;
import java.util.Set;

/**
 * @description: dag 工具类
 * @author: jiayancheng
 * @email: jiayancheng@foxmail.com
 * @datetime: 2020/5/7 8:42 下午
 * @version: 1.0.0
 */
public class DagUtils {
    /**
     * 当前节点和子节点：入度减一
     */
    public static void minusDegreeForToNodes(ExecuteNodeModel node) {
        //当前节点入度减1
        node.setFromDegree(node.getFromDegree() - 1);

        //校验
        List<ExecuteNodeModel> toNodes = node.getToNodes();
        if (CollectionUtil.isEmpty(toNodes)) {
            return;
        }

        //子节点入度减1
        for (ExecuteNodeModel toNode : toNodes) {
            toNode.setFromDegree(toNode.getFromDegree() - 1);
        }
    }

    /**
     * 补齐fromNodes
     */
    public static void addFromNodes(ExecuteNodeModel node,
                                    Set<ExecuteNodeModel> flatNodes) {
        List<ExecuteNodeModel> children = node.getToNodes();
        // 终止条件：无子节点
        if (CollectionUtil.isEmpty(children)) {
            return;
        }

        //添加节点
        flatNodes.addAll(children);

        //处理节点
        for (ExecuteNodeModel child : children) {
            //添加来源节点
            child.addFromNode(child);
            //计算入度: +1
            child.setFromDegree(child.getFromDegree() + 1);
            //继续递归遍历自己的
            addFromNodes(child, flatNodes);
        }
    }

}
