package com.vastracart.entity.resposneDto;

import com.vastracart.entity.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.SecondaryTable;
import java.util.List;

@Getter
@Setter
public class ProductResposneDTO extends Response{

    private List<Product> responeBody;
}
