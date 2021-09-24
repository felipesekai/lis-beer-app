package com.sekai.lisbeer.usecase

import com.sekai.lisbeer.data.Repository

class ProductListUseCase (private val repository: Repository) {
    operator  fun invoke() = repository.getAllProductsFromDataSource()
}