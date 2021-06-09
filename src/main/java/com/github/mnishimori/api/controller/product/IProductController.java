package com.github.mnishimori.api.controller.product;

import java.util.List;

import com.github.mnishimori.api.dto.product.ProductDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Produtct API")
public interface IProductController {

    @ApiOperation("Save product")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Product saved"),
            @ApiResponse(code = 400, message = "Validation error")
    })
	public ProductDto save(ProductDto productDto);
	
    @ApiOperation("Get product list")
	public List<ProductDto> list();
	
    @ApiOperation("Get product details")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Product found"),
        @ApiResponse(code = 404, message = "Product not found")
    })
	public ProductDto findById(Integer id);
	
    @ApiOperation("Get product list searching by any property")
	public List<ProductDto> search(ProductDto productDto);
	
    @ApiOperation("Update product")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Product updated"),
            @ApiResponse(code = 400, message = "Validation error")
    })
	public ProductDto update(Integer id, ProductDto productDto);
	
    @ApiOperation("Delete product")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Product deleted"),
            @ApiResponse(code = 400, message = "Product not found")
    })
	public void delete(Integer id);
}
