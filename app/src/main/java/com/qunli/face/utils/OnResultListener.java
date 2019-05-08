/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.qunli.face.utils;

import com.qunli.face.exception.FaceError;

public interface OnResultListener<T> {
    void onResult(T result);

    void onError(FaceError error);
}
