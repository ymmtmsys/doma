/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.doma.wrapper;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.seasar.doma.DomaNullPointerException;

/**
 * {@link BigInteger} のラッパーです。
 * 
 * @author taedium
 * 
 */
public class BigIntegerWrapper extends AbstractWrapper<BigInteger> implements
        NumberWrapper<BigInteger> {

    /**
     * インスタンスを構築します。
     */
    public BigIntegerWrapper() {
    }

    /**
     * 値を指定してインスタンスを構築します。
     * 
     * @param value
     *            値
     */
    public BigIntegerWrapper(BigInteger value) {
        super(value);
    }

    @Override
    public void set(Number v) {
        if (v instanceof BigInteger) {
            super.set((BigInteger) v);
        } else if (v instanceof BigDecimal) {
            super.set(((BigDecimal) v).toBigInteger());
        } else {
            super.set(BigInteger.valueOf(v.longValue()));
        }
    }

    @Override
    public void increment() {
        BigInteger value = doGet();
        if (value != null) {
            doSet(value.add(BigInteger.ONE));
        }
    }

    @Override
    public void decrement() {
        BigInteger value = doGet();
        if (value != null) {
            doSet(value.subtract(BigInteger.ONE));
        }
    }

    @Override
    public <R, P, TH extends Throwable> R accept(
            WrapperVisitor<R, P, TH> visitor, P p) throws TH {
        if (visitor == null) {
            throw new DomaNullPointerException("visitor");
        }
        return visitor.visitBigIntegerWrapper(this, p);
    }
}
