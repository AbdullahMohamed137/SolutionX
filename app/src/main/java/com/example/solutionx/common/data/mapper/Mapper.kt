package com.example.solutionx.common.data.mapper

import com.example.solutionx.features.login.domain.models.response.Login
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

    internal fun mapDtoToDomain(login: Login): User {
        return if (login.user != null) {
            User(
                accessToken = login.token,
                id = login.user.id,
                name = login.user.firstname + " " + login.user.middlename + " " + login.user.lastname,
                email = login.user.email,
                phoneNumber = login.user.phone.country_code + login.user.phone.number
            )
        } else {
            User()
        }
    }

    internal fun mapDomainToEntity(user: User): UserEntity {
        return UserEntity(
            user.accessToken.toString(), user.id.toString(),
            user.name.toString(), user.email.toString(), user.phoneNumber.toString()
        )
    }
}