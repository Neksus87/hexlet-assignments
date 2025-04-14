package exercise.mapper;

// BEGIN
import exercise.dto.ProductDTO;
import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    // Преобразование сущности в DTO
    @Mapping(target = "title", source = "name")
    @Mapping(target = "price", source = "cost")
    @Mapping(target = "vendorCode", source = "barcode")
    ProductDTO map(Product product);

    // Преобразование DTO в сущность
    @Mapping(target = "name", source = "title")
    @Mapping(target = "cost", source = "price")
    @Mapping(target = "barcode", source = "vendorCode")
    Product map(ProductCreateDTO dto);

    // Обновление сущности данными из DTO
    @Mapping(target = "cost", source = "price")
    void update(ProductUpdateDTO dto, @MappingTarget Product product);
}
// END
