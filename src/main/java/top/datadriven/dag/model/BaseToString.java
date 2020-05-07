package top.datadriven.dag.model;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @description: 基础类
 * @author: jiayancheng
 * @email: jiayancheng@foxmail.com
 * @datetime: 2020/04/14 下午9:07
 * @version: 1.0.0
 */
public class BaseToString implements Serializable {

    private static final long serialVersionUID = 3384234368715230535L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
