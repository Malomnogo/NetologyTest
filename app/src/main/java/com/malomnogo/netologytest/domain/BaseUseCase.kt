package com.malomnogo.netologytest.domain

abstract class BaseUseCase<Type> {

    abstract fun execute(): Type
}