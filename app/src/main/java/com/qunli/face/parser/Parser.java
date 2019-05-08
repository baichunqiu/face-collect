/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.qunli.face.parser;

import com.qunli.face.exception.FaceError;

/**
 * JSON解析
 * @param <T>
 */
public interface Parser<T> {
    T parse(String json) throws FaceError;
}
