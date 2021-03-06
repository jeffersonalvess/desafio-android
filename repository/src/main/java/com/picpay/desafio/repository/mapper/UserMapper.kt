package com.picpay.desafio.repository.mapper

import com.picpay.desafio.network.dto.User as UserDto
import com.picpay.desafio.database.entities.User as UserEntity

class UserMapper : Mapper<List<UserDto>, List<UserEntity>> {

    override fun map(from: List<UserDto>) =
        from.map { UserEntity(it.id, it.img, it.name, it.username) }
}
