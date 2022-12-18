package org.dhl.bookstore.model.service;

import org.dhl.bookstore.common.pojo.BSResult;
import org.dhl.bookstore.model.entity.Store;

import java.util.List;

public interface IStoreService {
    Store findStoreByUserId(Integer userId);

    Store findById(int storeId);

    List<Store> findStores();

    BSResult updateStore(Store store);

    BSResult deleteStore(int storeId);

    BSResult addStore(Store store);
}
