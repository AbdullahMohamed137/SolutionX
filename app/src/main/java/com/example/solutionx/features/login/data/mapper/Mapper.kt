package com.example.solutionx.features.login.data.mapper

import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.data.models.UserEntity
import com.example.solutionx.features.login.domain.models.User

object Mapper {

    internal fun mapEntityToDomain(userEntity: UserEntity): User {
        return User(
            userEntity.accessToken,
            userEntity.id,
            userEntity.name,
            userEntity.email,
            userEntity.phoneNumber
        )
    }

    internal fun mapDtoToDomain(userDto: UserDto): User {
        return User(
            userDto.accessToken.orEmpty(),
            userDto.id ?: -1,
            userDto.name.orEmpty(),
            userDto.email.orEmpty(),
            userDto.phoneNumber.orEmpty()
        )
    }

    internal fun mapDomainToEntity(user: User): UserEntity {
        return UserEntity(user.accessToken, user.id, user.name, user.email, user.phoneNumber)
    }
}