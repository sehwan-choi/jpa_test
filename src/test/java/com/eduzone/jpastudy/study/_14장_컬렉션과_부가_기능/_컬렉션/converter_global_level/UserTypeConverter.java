package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션.converter_global_level;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UserTypeConverter implements AttributeConverter<UserType, String> {

    @Override
    public String convertToDatabaseColumn(UserType attribute) {
        return UserType.STUDENT.equals(attribute) ? "Y" : "N";
    }

    @Override
    public UserType convertToEntityAttribute(String dbData) {
        return dbData.equals("Y") ? UserType.STUDENT : UserType.TEACHER;
    }
}
