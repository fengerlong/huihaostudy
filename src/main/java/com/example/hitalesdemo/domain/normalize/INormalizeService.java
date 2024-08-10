package com.example.hitalesdemo.domain.normalize;

import java.util.List;

public interface INormalizeService<T> {

    List<T> normalize(T t);
}
