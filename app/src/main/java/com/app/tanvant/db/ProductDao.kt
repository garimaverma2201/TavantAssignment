package com.app.tanvant.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.tanvant.model.ProductResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertProduct(productResponse: ProductResponse)

   @Delete
   suspend fun deleteProduct(product: ProductResponse)

   @Query("SELECT * FROM PRODUCT ORDER BY title ASC")
   fun getAllProduct(): Flow<List<ProductResponse>>
}