package com.kamil0nowak.blogapi.mappers;


import com.kamil0nowak.blogapi.domain.PostStatus;
import com.kamil0nowak.blogapi.domain.dto.CategoryDto;
import com.kamil0nowak.blogapi.domain.entities.Category;
import com.kamil0nowak.blogapi.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if (posts == null) return 0L;
        return posts.stream().filter(p -> p.getStatus().equals(PostStatus.PUBLISHED)).count();
    }
}
