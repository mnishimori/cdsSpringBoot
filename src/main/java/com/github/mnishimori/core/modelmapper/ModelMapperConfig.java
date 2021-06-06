package com.github.mnishimori.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		
		// Para realizar o mapeamento de cada classe com a correspondência dos atributos
		// é necessário um novo createTypeMap
		
		/*
		 * Mapeamento de atributos com nomes diferentes
		 * modelMapper.createTypeMap(Restaurante.class, RestauranteOutputDTO.class)
		 * .addMapping(Restaurante::getTaxaFrete, RestauranteOutputDTO::setPrecoFrete);
		 */
		
		// typeMap.<String>addMapping(src -> src.getC().getD(), (dest, value) -> dest.getE().setF(value))
		
		/*
		modelMapper.createTypeMap(Endereco.class, EnderecoOutputDTO.class).<String>addMapping(
				enderecoSrc -> enderecoSrc.getCidade().getEstado().getNome(), 
				(enderecoDest, value) -> enderecoDest.getCidade().setEstado(value));
		
		modelMapper.createTypeMap(ItemPedidoInputDto.class, ItemPedido.class)
	    .addMappings(mapper -> mapper.skip(ItemPedido::setId));  
		*/
		
		return modelMapper;
	}

}
