package com.example.solutionx.features.login.data.mapper

import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.data.models.UserEntity
import com.example.solutionx.features.login.domain.models.User

object Mapper {

    fun mapEntityToDomain(userEntity: UserEntity): User {
        return User(
            userEntity.id,
            userEntity.name,
            userEntity.email,
            userEntity.password,
            userEntity.phoneNumber
        )
    }

    fun mapDtoToDomain(userDto: UserDto): User {
        return User(userDto.id, userDto.name, userDto.email, userDto.password, userDto.phoneNumber)
    }

    fun mapDomainToEntity(user: User): UserEntity {
        return UserEntity(user.id, user.name, user.email, user.password, user.phoneNumber)
    }
}