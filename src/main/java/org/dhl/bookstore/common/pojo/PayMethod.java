package org.dhl.bookstore.common.pojo;

/**
 * Author: JieYuDa
 * Desc:
 * File created at 2020-6-3
 */
public enum PayMethod {
//定义两个常量及其值
        ZHIFUBAO(2),
        WEIXIN(1);


        private int value;

        PayMethod(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }


}
