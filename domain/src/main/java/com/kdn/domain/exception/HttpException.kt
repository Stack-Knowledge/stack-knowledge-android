package com.kdn.domain.exception

class WrongDataException(
    override val message: String?,
) : RuntimeException()

class InvalidTokenException(
    override val message: String?,
) : RuntimeException()

class NotFoundException(
    override val message: String?,
) : RuntimeException()

class ConflictDataException(
    override val message: String?,
) : RuntimeException()

class ServerErrorException(
    override val message: String?,
) : RuntimeException()

class UnKnownHttpException(
    override val message: String?,
) : RuntimeException()

class TooManyRequestException(
    override val message: String?,
) : RuntimeException()

class UnknownException(
    override val message: String?,
) : RuntimeException()

class BadRequestException(
    override val message: String?,
) : RuntimeException()

class TimeOutException(
    override val message: String?,
) : RuntimeException()

class NeedLoginException(
    override val message: String?,
) : RuntimeException()

class ForBiddenException(
    override val message: String?,
) : RuntimeException()