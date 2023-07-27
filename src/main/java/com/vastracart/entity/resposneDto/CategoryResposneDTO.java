package com.vastracart.entity.resposneDto;

import com.vastracart.entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryResposneDTO extends Response{
    private List<Category> resposneBody;
}
