package top.datadriven.dag.executor;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Sets;
import top.datadriven.dag.model.ExecuteNodeModel;
import top.datadriven.dag.model.ExecutePlan;
import top.datadriven.dag.util.DagUtils;

import java.util.Iterator;
import java.util.Set;

/**
 * @description: 执行计划执行器
 * @author: jiayancheng
 * @email: jiayancheng@foxmail.com
 * @datetime: 2020/5/7 4:33 下午
 * @version: 1.0.0
 */
public class PlanExecutor {

    public static void execute(ExecutePlan plan) {
        // 1.构建dag
        System.out.println(plan);

        // 2.补齐数据：fromNodes、入度
        Set<ExecuteNodeModel> flatNodes = Sets.newHashSet();
        // 添加根节点
        flatNodes.add(plan.getRootNode());
        DagUtils.addFromNodes(plan.getRootNode(), flatNodes);

        // 3.循环执行：直到所有节点执行完成
        executeNodes(flatNodes);
    }

    /**
     * 循环执行：直到所有节点执行完成
     * 执行过程中有三种状态：0表示可执行；-1表示已执行完成；>0表示不可执行
     */
    private static void executeNodes(Set<ExecuteNodeModel> flatNodes) {
        //1. 循环执行：直到所有节点执行完成
        while (CollectionUtil.isNotEmpty(flatNodes)) {
            Iterator<ExecuteNodeModel> flatNodesIterator = flatNodes.iterator();
            //2. 执行所有入度为0的节点
            while (flatNodesIterator.hasNext()) {
                //2.1 找到入度为0的节点：执行，并将后继节点减一
                ExecuteNodeModel node = flatNodesIterator.next();
                if (node.getFromDegree().equals(0)) {
                    //执行当前节点 --> TODO 优化：改为并发执行
                    executeNode(node);
                    //入度减1
                    DagUtils.minusDegreeForToNodes(node);
                }

                //2.2 入度为-1时，表示节点已经执行过，可以remove掉
                if (node.getFromDegree().equals(-1)) {
                    flatNodesIterator.remove();
                }
            }
        }
    }


    /**
     * 执行当前节点
     */
    private static void executeNode(ExecuteNodeModel node) {
        System.out.println("开始执行节点：" + node);
        //如果后续节点不需要执行，则移除掉
    }


}
