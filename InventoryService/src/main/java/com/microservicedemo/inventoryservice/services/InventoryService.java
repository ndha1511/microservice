package com.microservicedemo.inventoryservice.services;

import com.microservicedemo.inventoryservice.dto.InventoryResponse;
import com.microservicedemo.inventoryservice.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
       return inventoryRepository.findBySkuCodeIn(skuCode).stream()
               .map(inventory ->
                   InventoryResponse.builder().
                           isInStock(inventory.getQuantity() > 0).
                           skuCode(inventory.getSkuCode()).build()
               ).toList();
    }
}
