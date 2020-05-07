package top.datadriven.dag.executor;

import com.google.common.collect.Lists;
import org.junit.Test;
import top.datadriven.dag.model.ExecuteNodeModel;
import top.datadriven.dag.model.ExecutePlan;

/**
 * @description:
 * @author: jiayancheng
 * @email: jiayancheng@foxmail.com
 * @datetime: 2020/5/7 8:40 下午
 * @version: 1.0.0
 */
public class PlanExecutorTest {

    @Test
    public void testExecute_Success() {
        PlanExecutor.execute(getExecutePlan());
    }

    /**
     * 构造 DAG如下：
     * *       root
     * *    /    |    \
     * *   V     V     V
     * *   n1   n2     n3
     * *    \   /
     * *     V V
     * *     n4
     * *
     */
    private static ExecutePlan getExecutePlan() {
        ExecutePlan plan = new ExecutePlan();
        ExecuteNodeModel root = getNodeByCode("root");
        plan.setRootNode(root);
        ExecuteNodeModel n1 = getNodeByCode("n1");
        ExecuteNodeModel n2 = getNodeByCode("n2");
        ExecuteNodeModel n3 = getNodeByCode("n3");
        ExecuteNodeModel n4 = getNodeByCode("n4");
        root.setToNodes(Lists.newArrayList(n1, n2, n3));
        n1.setToNodes(Lists.newArrayList(n4));
        n2.setToNodes(Lists.newArrayList(n4));
        return plan;
    }

    private static ExecuteNodeModel getNodeByCode(String code) {
        ExecuteNodeModel nodeModel = new ExecuteNodeModel();
        nodeModel.setCode(code);
        return nodeModel;
    }

}
