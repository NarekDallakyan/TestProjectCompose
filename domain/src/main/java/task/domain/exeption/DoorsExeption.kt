package task.domain.exeption

open class DoorsException(message: String) : Exception(message)

class DoorLockException(message: String) : DoorsException(message)
class DoorUnlockException(message: String) : DoorsException(message)